package com.dieudonne.adminlte.common.mapper.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dieudonne.adminlte.common.mapper.model.SysUser;
public interface SysUserMapper extends BaseMapper<SysUser> {
	
	List<Map<Object, Object>> selectUserList(@Param("username") String username);
}