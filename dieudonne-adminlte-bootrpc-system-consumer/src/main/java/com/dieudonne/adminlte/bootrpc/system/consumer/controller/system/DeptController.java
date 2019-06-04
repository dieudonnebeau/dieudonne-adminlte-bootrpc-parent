package com.dieudonne.adminlte.bootrpc.system.consumer.controller.system;

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
import com.dieudonne.adminlte.bootrpc.system.service.ISysDeptService;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.common.util.CommonUtil;
import com.dieudonne.adminlte.model.system.SysDept;
/**
 * 
 * @ClassName:  DeptController   
 * @Description:部门控制器   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月30日 下午5:49:02   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/system/dept")
public class DeptController extends SuperController{  

	@Autowired private ISysDeptService sysDeptService;
	
	/**
	 * 分页查询部门
	 */
	@RequiresPermissions("listDept")
    @RequestMapping("/list/{pageNumber}")  
    public  String list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize, String search,Model model){
		if(StringUtils.isNotBlank(search)){
			model.addAttribute("search",search);
		}
		// 查询分页
		PageUtil<SysDept> pageData = sysDeptService.queryPage(new PageUtil<SysDept>(pageNumber , pageSize), search);
		model.addAttribute("pageData", pageData);
		return "system/dept/list";
    } 
    
    /**
     * 新增部门
     */
	@RequiresPermissions("addDept")
    @RequestMapping("/add")  
    public  String add(Model model){
		return "system/dept/add";
    } 
    
    /**
     * 执行新增
     */
	@RequiresPermissions("addDept")
    @Log("Création du nouveau département ")
    @RequestMapping("/doAdd")  
	@ResponseBody
    public  Rest doAdd(SysDept dept,String[] roleId){
		dept.setId(CommonUtil.getUuid());
    	sysDeptService.save(dept);
		return Rest.ok();
    }  
    /**
     * 删除部门
     */
	@RequiresPermissions("deleteDept")
    @Log("Supprimer le département")
    @RequestMapping("/delete")  
    @ResponseBody
    public  Rest delete(String id){
    	sysDeptService.deleteByID(id);
    	return Rest.ok();
    }  
    
	/**
	 * 编辑部门
	 */
	@RequiresPermissions("editDept")
    @RequestMapping("/edit/{id}")  
    public  String edit(@PathVariable String id,Model model){
    	SysDept dept = sysDeptService.queryByID(id);
    	
    	model.addAttribute("dept",dept);
    	return "system/dept/edit";
    } 
    /**
     * 执行编辑
     */
	@RequiresPermissions("editDept")
    @Log("Modifier le département")
    @RequestMapping("/doEdit")  
	@ResponseBody
    public  Rest doEdit(SysDept dept,Model model){
    	sysDeptService.updateByID(dept);
    	return Rest.ok();
    } 
	
}
