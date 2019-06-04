package com.dieudonne.adminlte.bootrpc.system.consumer.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dieudonne.adminlte.bootrpc.system.consumer.common.anno.Log;
import com.dieudonne.adminlte.bootrpc.system.consumer.common.bean.Rest;
import com.dieudonne.adminlte.bootrpc.system.consumer.common.controller.SuperController;
import com.dieudonne.adminlte.bootrpc.system.service.ISysMenuService;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.common.util.CommonUtil;
import com.dieudonne.adminlte.model.system.SysMenu;
import com.google.common.collect.Maps;
/**
 * 
 * @ClassName:  MenuController   
 * @Description:角色控制器   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月30日 下午5:51:45   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController extends SuperController{  

	/**
	 * 菜单服务
	 */
	@Autowired private ISysMenuService sysMenuService;
	
	/**
	 * 分页查询菜单
	 */
	@RequiresPermissions("listMenu")
    @RequestMapping("/list/{pageNumber}")  
    public  String list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize, String search,Model model){
    	
		if(StringUtils.isNotBlank(search)){
			model.addAttribute("search",search);
		}
		PageUtil<SysMenu> pageData = sysMenuService.queryPage(new PageUtil<>(pageNumber,pageSize), search);
		
		for(SysMenu menu : pageData.getRows()){
			if(menu.getPid() == null || menu.getDeep() !=3){
				menu.setMenuname(StringUtils.join("<i class='fa fa-folder-open'></i> ",menu.getMenuname()));
			}else{
				menu.setMenuname(StringUtils.join("<i class='fa fa-file'></i> ",menu.getMenuname()));
			}
			for(int i=1;i<menu.getDeep();i++){
				menu.setMenuname(StringUtils.join("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;",menu.getMenuname()));
			}
			
		}
		
		model.addAttribute("pageData", pageData);
		return "system/menu/list";
    } 
   
    /**
     * 增加菜单
     */
	@RequiresPermissions("addMenu")
    @RequestMapping("/add")
    public String add(Model model){
    	List<SysMenu> list = sysMenuService.queryListByPid("0");
    	model.addAttribute("list",list);
    	return "system/menu/add";
		
    } 
    /**
     * 添加目录
     */
	@RequiresPermissions("addMenu")
    @Log("Création du menu du répertoire")
    @RequestMapping("/doAddDir")
	@ResponseBody
    public Rest doAddDir(SysMenu sysMenu,Model model){
		sysMenu.setId(CommonUtil.getUuid());
    	sysMenu.setPid("0");
    	sysMenu.setDeep(1);
    	sysMenuService.save(sysMenu);
    	return Rest.ok();
    } 
    
    /**
     * 添加菜单
     */
	@RequiresPermissions("addMenu")
    @Log("Création du menu")
    @RequestMapping("/doAddMenu")
	@ResponseBody
    public Rest doAddMenu(SysMenu sysMenu,Model model){
		sysMenu.setId(CommonUtil.getUuid());
    	sysMenu.setDeep(2);
    	sysMenuService.save(sysMenu);
    	return Rest.ok();
    } 
    /**
     * 编辑菜单
     */
	@RequiresPermissions("editMenu")
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id,Model model){
    	SysMenu sysMenu =sysMenuService.queryByID(id);
    	model.addAttribute("sysMenu", sysMenu);
    	
    	if(sysMenu.getDeep() == 1){
    		return  "/system/menu/edit";
    	}else if(sysMenu.getDeep() == 2){
        	List<SysMenu> list = sysMenuService.queryListByPid("0");;
        	model.addAttribute("list",list);
        	return "/system/menu/editMenu";
    	}
    	else{
        	List<SysMenu> list = sysMenuService.queryListByPid("0");
        	model.addAttribute("list",list);
        	model.addAttribute("pSysMenu",sysMenuService.queryByID(sysMenu.getPid()));
    		return  "/system/menu/editAction";
    	}
    } 
    
    /**
     * 执行编辑菜单
     */
	@RequiresPermissions("editMenu")
    @Log("Modifier le menu")
    @RequestMapping("/doEdit")
	@ResponseBody
    public Rest doEdit(SysMenu sysMenu,Model model){
    	sysMenuService.updateByIDNotNull(sysMenu);
    	return Rest.ok();
    } 
    
    /**
     * 执行编辑菜单
     */
	@RequiresPermissions("deleteMenu")
    @Log("Supprimer le menu")
    @RequestMapping("/delete")
    @ResponseBody
    public Rest delete(String id){
    	sysMenuService.deleteByID(id);
    	return Rest.ok();
    } 
    
    /**
     * 根据父节点获取子菜单
     */
    @RequestMapping("/json")
    @ResponseBody
    public Rest json(String pid){
    	List<SysMenu> list = sysMenuService.queryListByPid(pid);
    	
    	List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
    	for(SysMenu m : list){
    		Map<String, Object> map = Maps.newHashMap();
    		map.put("id", m.getId());
    		map.put("text",StringUtils.join(m.getCode(),"-",m.getMenuname()));
    		listMap.add(map);
    	}
    	return Rest.okData(listMap);
    } 
    
    
    /**
     * 验证菜单资源名称是否存在
     */
    @RequestMapping("/checkMenuResource")  
    @ResponseBody
    public Rest checkMenuResource(String resource){
    	List<SysMenu> list = sysMenuService.queryListByResource(resource);
    	if(list.size() > 0){
    		return Rest.failure("资源已存在,请换一个尝试.");
    	}
    	return Rest.ok();
    }
    
    @RequiresPermissions("addMenu")
    @Log("Nouveau fonctionnel menu")
    @RequestMapping("/doAddAction")
    public String doAddAction(SysMenu sysMenu,Model model){
    	sysMenu.setId(CommonUtil.getUuid());
    	sysMenu.setDeep(3);
    	sysMenuService.save(sysMenu);
    	return redirectTo("/system/menu/list/1.html");
    } 
}
