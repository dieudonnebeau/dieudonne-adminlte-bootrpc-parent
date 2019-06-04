package com.dieudonne.adminlte.bootrpc.system.service;

import java.util.List;
import java.util.Set;

import com.dieudonne.adminlte.common.mapper.service.IBaseService;
import com.dieudonne.adminlte.model.system.SysRoleMenu;


/**
 *
 * SysRoleMenu 表数据服务层接口
 *
 */
public interface ISysRoleMenuService extends IBaseService<SysRoleMenu> {
	
	/**
	 * 
	 * @Title: addAuth   
	 * @Description: 角色授权   
	 * @param: @param roleId
	 * @param: @param menuIds      
	 * @return: void      
	 * @throws
	 */
	void addAuth(String roleId, String[] menuIds);
	
	/**
	 * 
	 * @Title: selectByRole   
	 * @Description: 获取指定角色的权限 
	 * @param: @param roleId
	 * @param: @return      
	 * @return: List<SysRoleMenu>      
	 * @throws
	 */
	List<SysRoleMenu> selectByRole(String roleId);

	/**
	 * 
	 * @Title: findMenusByUid   
	 * @Description: 根据ID获取   
	 * @param: @param id
	 * @param: @return      
	 * @return: Set<String>      
	 * @throws
	 */
	Set<String> findMenusByUid(String id);


}