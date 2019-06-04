package com.dieudonne.adminlte.system.service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.bootrpc.system.service.ISysDeptService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.model.system.SysDept;
import com.dieudonne.adminlte.system.mapper.SysDeptMapper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * 
 * @ClassName:  SysDeptServiceImpl   
 * @Description:SysDept 表数据服务层接口实现类   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月28日 上午10:53:39   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = SysDeptServiceImpl.BEAN_NAME)
public class SysDeptServiceImpl extends BaseServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {
	public final static String BEAN_NAME = "deptService";

	@Override
	public PageUtil<SysDept> queryPage(PageUtil<SysDept> page, String search) {
		Example example = new Example(SysDept.class);
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(search)){
			criteria.andLike("deptName","%"+search+"%");
		}
		return queryByExample(page, example);
	}

}