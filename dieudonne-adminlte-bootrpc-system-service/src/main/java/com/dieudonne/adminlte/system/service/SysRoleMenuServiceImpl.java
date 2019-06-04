package com.dieudonne.adminlte.system.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.bootrpc.system.service.ISysRoleMenuService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.common.util.CommonUtil;
import com.dieudonne.adminlte.model.system.SysRoleMenu;
import com.dieudonne.adminlte.system.mapper.SysMenuMapper;
import com.dieudonne.adminlte.system.mapper.SysRoleMenuMapper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;



/**
 *
 * SysRoleMenu 表数据服务层接口实现类
 *
 */
@Service(value = SysRoleMenuServiceImpl.BEAN_NAME)
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {
	public final static String BEAN_NAME = "roleMenuService";
	@Autowired private SysMenuMapper sysMenuMapper;
	
	@Override
	public void addAuth(String roleId, String[] menuIds) {
		
		/**
		 * 删除原有权限
		 */
		Example example = new Example(SysRoleMenu.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("roleid", roleId);
		this.deleteByExample(example);
		/**
		 * 重新授权
		 */
		if(ArrayUtils.isNotEmpty(menuIds)){
			for(String menuId : menuIds){
				SysRoleMenu sysRoleMenu2 = new SysRoleMenu();
				sysRoleMenu2.setId(CommonUtil.getUuid());
				sysRoleMenu2.setRoleid(roleId);
				sysRoleMenu2.setMenuid(menuId);
				this.save(sysRoleMenu2);
			}
		}
	}

	@Override
	public List<SysRoleMenu> selectByRole(String roleId) {
		Example example = new Example(SysRoleMenu.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("roleid", roleId);
		return this.queryByExample(example);
		
	}

	@Override
	public Set<String> findMenusByUid(String id) {
		List<String> list =  sysMenuMapper.selectResourceByUid(id);
		return new HashSet<>(list);
	}


}