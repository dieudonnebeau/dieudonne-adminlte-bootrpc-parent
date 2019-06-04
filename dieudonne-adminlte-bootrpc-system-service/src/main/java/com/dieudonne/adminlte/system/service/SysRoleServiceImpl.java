package com.dieudonne.adminlte.system.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.bootrpc.system.service.ISysRoleService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.model.system.SysRole;
import com.dieudonne.adminlte.system.mapper.SysRoleMapper;

import tk.mybatis.mapper.entity.Example;


/**
 * 
 * @ClassName:  SysRoleServiceImpl   
 * @Description:SysRole 表数据服务层接口实现类  
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月28日 上午11:48:03   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = SysRoleServiceImpl.BEAN_NAME)
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
	public final static String BEAN_NAME = "roleService";

	@Override
	public PageUtil<SysRole> queryPage(PageUtil<SysRole> page, String rolename) {
		Example example = new Example(SysRole.class);
		example.setOrderByClause("createTime DESC");
		Example.Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(rolename)){
			criteria.andLike("roleName","%"+rolename+"%");
		}
		return queryByExample(page , example);
	}


}