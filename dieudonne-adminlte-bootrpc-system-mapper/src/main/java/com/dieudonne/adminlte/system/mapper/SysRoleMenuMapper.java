package com.dieudonne.adminlte.system.mapper;

import java.util.List;

import com.dieudonne.adminlte.common.mapper.dao.BaseMapper;
import com.dieudonne.adminlte.model.system.SysRoleMenu;


public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
	
	/**
	 * 根据用户Id获取用户所在角色的权限
	 */
	public List<String> selectRoleMenuIdsByUserId(String uid);
}