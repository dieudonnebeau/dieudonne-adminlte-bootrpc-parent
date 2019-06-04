package com.dieudonne.adminlte.system.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.bootrpc.system.service.ISysUserRoleService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.model.system.SysUserRole;
import com.dieudonne.adminlte.system.mapper.SysUserRoleMapper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;



/**
 * 
 * @ClassName:  SysUserRoleServiceImpl   
 * @Description:SysUserRole 表数据服务层接口实现类   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月28日 上午11:52:05   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = SysUserRoleServiceImpl.BEAN_NAME)
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {
	public final static String BEAN_NAME = "userRoleService";
	@Override
	public Set<String> findRolesByUid(String uid) {
		Example example = new Example(SysUserRole.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userid", uid);
		List<SysUserRole> list = this.queryByExample(example);

		Set<String> set = new HashSet<String>();
		for (SysUserRole ur : list) {
			set.add(ur.getRoleid());
		}
		return set;
	}
	@Override
	public List<SysUserRole> queryListByUserId(String userId) {
		Example example = new Example(SysUserRole.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userid",userId);
		return queryByExample(example);
	}
}