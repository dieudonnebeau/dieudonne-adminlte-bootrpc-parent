package com.dieudonne.adminlte.bootrpc.system.consumer.controller.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.dieudonne.adminlte.bootrpc.system.service.ISysRoleMenuService;
import com.dieudonne.adminlte.bootrpc.system.service.ISysRoleService;
import com.dieudonne.adminlte.bootrpc.system.service.ISysUserRoleService;
import com.dieudonne.adminlte.bootrpc.system.service.ISysUserService;
import com.dieudonne.adminlte.common.mapper.model.SysUser;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.model.system.SysRole;
import com.dieudonne.adminlte.model.system.SysRoleMenu;
import com.dieudonne.adminlte.model.system.SysUserRole;
import com.dieudonne.adminlte.system.vo.TreeMenuAllowAccess;
import com.google.common.collect.Lists;

import tk.mybatis.mapper.entity.Example;
/**
 * 
 * @ClassName:  RoleController   
 * @Description:角色控制器   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月30日 下午5:53:26   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends SuperController{  

	/**
	 * 角色服务
	 */
	@Autowired private ISysRoleService sysRoleService;
	/**
	 * 角色用户服务
	 */
	@Autowired private ISysUserRoleService sysUserRoleService;
	/**
	 * 用户服务
	 */
	@Autowired private ISysUserService sysUserService;
	/**
	 * 菜单服务
	 */
	@Autowired private ISysMenuService sysMenuService;
	/**
	 * 角色权限服务
	 */
	@Autowired private ISysRoleMenuService sysRoleMenuService;
	
	/**
	 * 分页查询角色
	 */
	@RequiresPermissions("listRole")
    @RequestMapping("/list/{pageNumber}")  
    public  String list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize, String search,Model model){
		if(StringUtils.isNotBlank(search)){
			model.addAttribute("search",search);
		}
		// 查询分页
		PageUtil<SysRole> pageData = sysRoleService.queryPage(new PageUtil<SysRole>(pageNumber,pageSize), search);
		model.addAttribute("pageData", pageData);
		return "system/role/list";
    } 
    
    /**
     * 新增角色
     */
	@RequiresPermissions("addRole")
    @RequestMapping("/add")  
    public  String add(Model model){
		return "system/role/add";
    } 
    
    /**
     * 执行新增角色
     */
	@RequiresPermissions("addRole")
    @Log("Création d’un rôle")
    @RequestMapping("/doAdd")  
	@ResponseBody
    public  Rest doAdd(SysRole role){
    	role.setCreatetime(new Date());
    	sysRoleService.save(role);
		return Rest.ok();

    }  
    
    /**
     * 删除角色
     */
	@RequiresPermissions("deleteRole")
    @Log("Supprimer le rôle")
    @RequestMapping("/delete")  
    @ResponseBody
    public  Rest delete(String id){
    	sysRoleService.deleteByID(id);
    	return Rest.ok();
    }  

    /**
     * 批量删除角色
     */
	@RequiresPermissions("deleteBatchRole")
    @Log("Supprimer une liste de rôles")
    @RequestMapping("/deleteBatch")  
    @ResponseBody
    public Rest deleteBatch(@RequestParam("id[]") List<String> ids){
		Example example = new Example(SysRole.class);
		// 查询分页
		Example.Criteria criteria = example.createCriteria();
		criteria.andIn("id", ids);
    	sysRoleService.deleteByExample(example);
    	return Rest.ok();
    }  
    
    /**
     * 编辑角色
     */
	@RequiresPermissions("editRole")
    @RequestMapping("/edit/{id}")  
    public  String edit(@PathVariable String id,Model model){
    	SysRole sysRole = sysRoleService.queryByID(id);
    	model.addAttribute(sysRole);
    	return "system/role/edit";
    } 
    
    /**
     * 执行编辑角色
     */
	@RequiresPermissions("editRole")
    @Log("Modifier le rôle ")
    @RequestMapping("/doEdit")  
	@ResponseBody
    public  Rest doEdit(SysRole sysRole,Model model){
    	sysRoleService.updateByID(sysRole);
    	return Rest.ok();
    } 
    
    /**
     * 权限
     */
	@RequiresPermissions("authRole")
    @RequestMapping("/auth/{id}")  
    public  String auth(@PathVariable String id,Model model){
    	
    	SysRole sysRole = sysRoleService.queryByID(id);
    	
    	if(sysRole == null){
    		throw new RuntimeException("该角色不存在");
    	}
    	List<SysRoleMenu> sysRoleMenus = sysRoleMenuService.selectByRole(id);
    	List<String> menuIds = Lists.transform(sysRoleMenus,input -> input.getMenuid());  	
    	List<TreeMenuAllowAccess> treeMenuAllowAccesses = sysMenuService.selectTreeMenuAllowAccessByMenuIdsAndPid(menuIds, "0");

    	model.addAttribute("sysRole", sysRole);
    	model.addAttribute("treeMenuAllowAccesses", treeMenuAllowAccesses);
    	
    	return "system/role/auth";
    } 
    
    /**
     * 权限
     */
	@RequiresPermissions("authRole")
    @Log("Attribution de l'autorisation compétences")
    @RequestMapping("/doAuth")  
	@ResponseBody
    public  Rest doAuth(String roleid,@RequestParam(value="mid[]",required=false) String[] mid){
    	sysRoleMenuService.addAuth(roleid,mid);
    	return Rest.ok("OK,Autorisation de succès, entrée en vigueur dans une minute  ~");
    } 
	
	/**
	 * 获取角色下的所有用户
	 */
	@RequestMapping("/getUsers")  
	public String getUsers(String roleId,Model model){
		
		Example example = new Example(SysRoleMenu.class);
		// 查询分页
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("roleId", roleId);
		
		List<SysUserRole> sysUserRoles = sysUserRoleService.queryByExample(example);
		
		List<String> userIds = Lists.transform(sysUserRoles,input -> input.getUserid());
		
		List<SysUser> users  = new ArrayList<SysUser>();
		
		if(userIds.size() > 0){
			Example example1 = new Example(SysUser.class);
			// 查询分页
			Example.Criteria criteria1 = example1.createCriteria();
			criteria1.andIn("id", userIds);
			users= sysUserService.queryByExample(example1);
		}
		
		model.addAttribute("users",users);
		return "system/role/users";
	}
	
	/**
	 * 获取指定角色的用户数量
	 */
	@RequestMapping("/getCount")  
	@ResponseBody
	public String getCount(String roleId){
		SysUserRole sysUserRole = new  SysUserRole();
		sysUserRole.setRoleid(roleId);
		int count =  sysUserRoleService.queryCount(sysUserRole);
		return String.valueOf(count);
	}
	
}
