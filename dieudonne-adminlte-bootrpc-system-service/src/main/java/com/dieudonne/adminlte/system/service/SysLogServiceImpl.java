package com.dieudonne.adminlte.system.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.bootrpc.system.service.ISysLogService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.common.util.CommonUtil;
import com.dieudonne.adminlte.model.system.SysLog;
import com.dieudonne.adminlte.system.mapper.SysLogMapper;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @ClassName:  SysLogServiceImpl   
 * @Description:SysLog 表数据服务层接口实现类   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月28日 上午10:55:04   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = SysLogServiceImpl.BEAN_NAME)
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog> implements ISysLogService {
	public final static String BEAN_NAME = "logService";
	public static final Logger logger = LoggerFactory.getLogger(SysLogServiceImpl.class);
	
	@Override
	public void insertLog(String title, String uname, String url, String parms) {
		SysLog sysLog  =new SysLog();
		sysLog.setId(CommonUtil.getUuid());
		sysLog.setCreatetime(new Date());
		sysLog.setTitle(title);
		sysLog.setUsername(uname);
		sysLog.setUrl(url);
		sysLog.setParams(parms);
		super.save(sysLog);
		logger.debug("Enregistrement de Log :"+sysLog.toString());
	}

	@Override
	public PageUtil<SysLog> queryPage(PageUtil<SysLog> page, String search, String daterange) {
		Example example = new Example(SysLog.class);
		Example.Criteria criteria = example.createCriteria();
		example.setOrderByClause("createtime DESC"); 	
		// 查询分页
		if(StringUtils.isNotBlank(search)){
			example.or(example.createCriteria().andLike("username",search));
			example.or(example.createCriteria().andLike("title", search));
		}
		//日期查询
		if(StringUtils.isNotBlank(daterange)){
			String[] dateranges = StringUtils.split(daterange, "-");
			String startTime = dateranges[0].trim().replaceAll("/","-") + " 00:00:00";
			String endTime = dateranges[1].trim().replaceAll("/","-") + " 23:59:59";
			criteria.andBetween("createtime", startTime, endTime);
		}
		return queryByExample(page, example);
	}


}