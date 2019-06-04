package com.dieudonne.adminlte.bootrpc.system.service;

import java.util.List;

import com.dieudonne.adminlte.common.mapper.service.IBaseService;
import com.dieudonne.adminlte.model.system.SysSetting;

/**
 * 
 * @ClassName:  ISysSettingService   
 * @Description:SysSetting 表数据服务层接口   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 下午5:40:36   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface ISysSettingService extends IBaseService<SysSetting> {
	/**
	 * 
	 * @Title: findAll   
	 * @Description: 查询所有   
	 * @param: @return      
	 * @return: List<SysSetting>      
	 * @throws
	 */
	List<SysSetting> findAll();
	
	List<SysSetting> queryPage();
}