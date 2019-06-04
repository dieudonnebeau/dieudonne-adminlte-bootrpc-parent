package com.dieudonne.adminlte.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dieudonne.adminlte.common.mapper.dao.BaseMapper;
import com.dieudonne.adminlte.model.system.SysMenu;


public interface SysMenuMapper extends BaseMapper<SysMenu>{
	
	List<String> selectMenuIdsByuserId(String uid);

	List<String> selectResourceByUid(@Param("uid") String uid);
}