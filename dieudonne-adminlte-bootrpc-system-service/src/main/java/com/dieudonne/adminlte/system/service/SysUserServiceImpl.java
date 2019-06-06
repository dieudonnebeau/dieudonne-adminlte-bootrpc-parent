package com.dieudonne.adminlte.system.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.bootrpc.system.service.ISysUserService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.common.mapper.util.ShiroUtil;
import com.dieudonne.adminlte.common.util.CommonUtil;
import com.dieudonne.adminlte.model.common.SysUser;
import com.dieudonne.adminlte.model.system.SysUserRole;
import com.dieudonne.adminlte.system.mapper.SysUserMapper;
import com.dieudonne.adminlte.system.mapper.SysUserRoleMapper;
import com.github.pagehelper.page.PageMethod;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * 
 * @ClassName:  SysUserServiceImpl   
 * @Description:SysUser 表数据服务层接口实现类  
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月28日 上午11:54:54   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = SysUserServiceImpl.BEAN_NAME)
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
	public final static String BEAN_NAME = "userService";
	@Autowired private SysUserMapper userMapper;
	
	@Autowired private SysUserRoleMapper userRoleMapper;
	
	@Override
	public void insertUser(SysUser user, String[] roleIds) {
		// TODO Auto-generated method stub
		user.setId(CommonUtil.getUuid());
		user.setCreatetime(new Date());
    	user.setPassword(ShiroUtil.md51024Pwd(user.getPassword(), user.getUsername()));
		//保存用户
    	userMapper.insert(user);
		//绑定角色
		if(ArrayUtils.isNotEmpty(roleIds)){
			for(String rid : roleIds){
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setUserid(user.getId());
				sysUserRole.setRoleid(rid);
				userRoleMapper.insert(sysUserRole);
			}
		}
		
	}

	@Override
	public void updateUser(SysUser sysUser, String[] roleIds) {
		// TODO Auto-generated method stub
		sysUser.setPassword(null);
		//更新用户
		userMapper.updateByPrimaryKeySelective(sysUser);
		//删除已有权限
		Example example = new Example(SysUser.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userId",sysUser.getId());
		userRoleMapper.deleteByExample(example);
		//重新绑定角色
		if(ArrayUtils.isNotEmpty(roleIds)){
			for(String rid : roleIds){
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setUserid(sysUser.getId());
				sysUserRole.setRoleid(rid);
				userRoleMapper.insert(sysUserRole);
			}
		}
	}

	@Override
	public PageUtil<Map<Object, Object>> selectUserPage(PageUtil<SysUser> page, String username) {
		PageMethod.startPage(page.getPageNo(), page.getPageSize());
		List<Map<Object, Object>> list = userMapper.selectUserList(username);
		return new PageUtil<Map<Object, Object>>(list);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		super.deleteByID(id);
		Example example = new Example(SysUser.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userid",id);
		userRoleMapper.deleteByExample(example);
	}

	@Override
	public SysUser queryByUsername(String username) {
		Example example = new Example(SysUser.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("username",username);
		return queryOneByExample(example);
	}


}