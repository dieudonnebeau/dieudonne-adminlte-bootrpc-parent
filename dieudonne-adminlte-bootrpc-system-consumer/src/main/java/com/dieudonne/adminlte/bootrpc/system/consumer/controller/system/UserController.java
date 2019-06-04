package com.dieudonne.adminlte.bootrpc.system.consumer.controller.system;

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
import com.dieudonne.adminlte.bootrpc.system.service.ISysDeptService;
import com.dieudonne.adminlte.bootrpc.system.service.ISysRoleService;
import com.dieudonne.adminlte.bootrpc.system.service.ISysUserRoleService;
import com.dieudonne.adminlte.bootrpc.system.service.ISysUserService;
import com.dieudonne.adminlte.common.mapper.model.SysUser;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.model.system.SysRole;
import com.dieudonne.adminlte.model.system.SysUserRole;
import com.google.common.collect.Lists;

/**
 * 
 * @ClassName:  UserController   
 * @Description:用户控制器   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月30日 下午5:56:36   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends SuperController{  

	@Autowired private ISysUserService sysUserService;
	@Autowired private ISysRoleService sysRoleService;
	@Autowired private ISysUserRoleService sysUserRoleService;
	@Autowired private ISysDeptService sysDeptService;
	
	/**
	 * 分页查询用户
	 */
	@RequiresPermissions("listUser")
    @RequestMapping("/list/{pageNumber}")  
    public  String list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize,String search,Model model){
		if(StringUtils.isNotBlank(search)){
			model.addAttribute("search", search);
		}
    	model.addAttribute("pageSize", pageSize);
    	PageUtil<Map<Object, Object>> pageData = sysUserService.selectUserPage(new PageUtil<SysUser>(pageNumber,pageSize ) , search);
    	model.addAttribute("pageData", pageData);
    	return "system/user/list";
    } 
    /**
     * 新增用户
     */
	@RequiresPermissions("addUser")
    @RequestMapping("/add")  
    public  String add(Model model){
    	model.addAttribute("roleList", sysRoleService.queryAll());
    	model.addAttribute("deptList", sysDeptService.queryAll());
		return "system/user/add";
    } 
    
    /**
     * 执行新增
     */
    @Log("Créer de l'utilisateur.")
    @RequiresPermissions("addUser")
    @RequestMapping("/doAdd")  
    @ResponseBody
    public  Rest doAdd(SysUser user,@RequestParam(value="roleId[]",required=false) String[] roleId){
    	
    	sysUserService.insertUser(user,roleId);
    	return Rest.ok();
    }  
    /**
     * 删除用户
     */
    @Log("Supprimer l'utilisateur.")
    @RequiresPermissions("deleteUser")
    @RequestMapping("/delete")  
    @ResponseBody
    public  Rest delete(String id){
    	sysUserService.delete(id);
    	return Rest.ok();
    }  
    
	/**
	 * 编辑用户
	 */
    @RequestMapping("/edit/{id}")  
    @RequiresPermissions("editUser")
    public  String edit(@PathVariable String id,Model model){
    	SysUser sysUser = sysUserService.queryByID(id);
    	
    	List<SysRole> sysRoles = sysRoleService.queryAll();
    	List<SysUserRole> mySysUserRoles = sysUserRoleService.queryListByUserId(id);
    	List<String> myRolds = Lists.transform(mySysUserRoles, input -> input.getRoleid());
    	
    	model.addAttribute("sysUser",sysUser);
    	model.addAttribute("sysRoles",sysRoles);
    	model.addAttribute("myRolds",myRolds);
    	model.addAttribute("deptList", sysDeptService.queryAll());
    	return "system/user/edit";
    } 
    /**
     * 执行编辑
     */
    @Log("Modifier l'utilisateur.")
    @RequiresPermissions("editUser")
    @RequestMapping("/doEdit")  
    @ResponseBody
    public  Rest doEdit(SysUser sysUser,@RequestParam(value="roleId[]",required=false) String[] roleId,Model model){
    	sysUserService.updateUser(sysUser,roleId);
    	return Rest.ok();
    } 
    
    /**
     * 验证用户名是否已存在
     */
    @RequestMapping("/checkName")  
    @ResponseBody
    public Rest checkName(String username){
    	SysUser user = sysUserService.queryByUsername(username);
    	if(user!=null){
    		return Rest.failure("Le nom d’utilisateur existe déjà.");
    	}
    	return Rest.ok();
    }
    
}
