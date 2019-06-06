package com.dieudonne.adminlte.system.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dieudonne.adminlte.common.mapper.dao.BaseMapper;
import com.dieudonne.adminlte.model.common.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser> {
	List<Map<Object, Object>> selectUserList(@Param("username") String username);
}