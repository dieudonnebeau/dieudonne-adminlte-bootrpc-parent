package com.dieudonne.adminlte.bootrpc.blog.consumer.common.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dieudonne.adminlte.bootrpc.blog.consumer.common.anno.Log;
import com.dieudonne.adminlte.bootrpc.blog.consumer.common.utils.SpringUtil;
import com.dieudonne.adminlte.bootrpc.system.service.ISysLogService;
import com.dieudonne.adminlte.common.mapper.model.SysUser;
import com.dieudonne.adminlte.common.mapper.util.ShiroUtil;
import com.dieudonne.adminlte.common.util.CommonUtil;
import com.dieudonne.adminlte.model.system.SysLog;
import com.google.gson.Gson;

/**
 * 
 * @ClassName:  LogAdvice   
 * @Description:正常业务日志记录  
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 下午5:53:21   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Aspect
@Component
public class LogAdvice {
	
	public static final Logger LOG = LoggerFactory.getLogger(LogAdvice.class);
	
	@Pointcut("@annotation(com.dieudonne.adminlte.bootrpc.system.consumer.common.anno.Log)")
	public void controllerAspect() {
		
	}
	/**
	 * 
	 * @Title: doBefore   
	 * @Description: 当方法正常返回是执行   
	 * @param: @param joinPoint      
	 * @return: void      
	 * @throws
	 */
	@AfterReturning("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Log log =  method.getAnnotation(Log.class);
		SysUser sysUser = ShiroUtil.getSessionUser();
		if(log != null){
			SysLog sysLog  =new SysLog();
			sysLog.setId(CommonUtil.getUuid());
			sysLog.setCreatetime(new Date());
			sysLog.setTitle(log.value());
			sysLog.setUsername((sysUser != null )? sysUser.getUsername() : "system");
			sysLog.setUrl(request.getRequestURI().toString());
			sysLog.setParams(new Gson().toJson(request.getParameterMap()));
			SpringUtil.getBean(ISysLogService.class).save(sysLog);
			LOG.debug("记录日志:"+sysLog.toString());
		}
	}
}
