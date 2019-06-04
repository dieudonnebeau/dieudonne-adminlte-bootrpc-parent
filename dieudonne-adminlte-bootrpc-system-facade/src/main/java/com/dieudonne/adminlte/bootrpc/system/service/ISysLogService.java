package com.dieudonne.adminlte.bootrpc.system.service;

import com.dieudonne.adminlte.common.mapper.service.IBaseService;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.model.system.SysLog;

/**
 * 
 * @ClassName:  ISysLogService   
 * @Description:SysLog 表数据服务层接口   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 下午5:48:30   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface ISysLogService extends IBaseService<SysLog> {

	/**
	 * 记录日志
	 * @param title
	 * @param uname
	 * @param url
	 * @param parms
	 */
	void insertLog(String title, String uname, String url, String parms);
	
	PageUtil<SysLog> queryPage(PageUtil<SysLog> page, String search , String daterange);


}