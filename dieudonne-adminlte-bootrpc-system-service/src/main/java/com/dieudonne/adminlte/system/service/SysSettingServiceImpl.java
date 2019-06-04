package com.dieudonne.adminlte.system.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.bootrpc.system.service.ISysSettingService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.model.system.SysSetting;
import com.dieudonne.adminlte.system.mapper.SysSettingMapper;

import tk.mybatis.mapper.entity.Example;



/**
 * 
 * @ClassName:  SysSettingServiceImpl   
 * @Description:SysSetting 表数据服务层接口实现类   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月28日 上午11:48:20   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = SysSettingServiceImpl.BEAN_NAME)
public class SysSettingServiceImpl extends BaseServiceImpl<SysSettingMapper, SysSetting> implements ISysSettingService {
	public final static String BEAN_NAME = "settingService";
	@Cacheable(value = "settingCache")
	@Override
	public List<SysSetting> findAll() {
		Example example = new Example(SysSetting.class);
		example.setOrderByClause("sort ASC");
		return this.queryByExample(example);
	}
	@Override
	public List<SysSetting> queryPage() {
		Example example = new Example(SysSetting.class);
		example.setOrderByClause("sort ASC");    	
    	List<SysSetting> list =  queryByExample(example);
    	return list;
	}


}