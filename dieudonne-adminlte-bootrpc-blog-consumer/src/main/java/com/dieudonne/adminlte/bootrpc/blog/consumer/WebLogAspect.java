package com.dieudonne.adminlte.bootrpc.blog.consumer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.alibaba.fastjson.JSONObject;

@Component
@Aspect
public class WebLogAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(public * com.dieudonne.adminlte.bootrpc.blog.consumer.controller.*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		StringBuilder builder = new StringBuilder();
		builder.append("Request IP is : " + request.getRemoteAddr() + " ; ");
		builder.append("Request URL is : " + request.getRequestURL().toString() + " ; ");
		builder.append("Request Method is : " + request.getMethod() + " ; ");
		JSONObject json = new JSONObject(getParameterMap(request));
		builder.append("Request args : " + json.toString());
		logger.info(builder.toString());
		
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.info("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//logger.info("RESPONSE : " + ret);
	}

	// 返回值类型为Map<String, Object>
	Map<String, Object> getParameterMap(HttpServletRequest request) {
		Map<String, String[]> properties = request.getParameterMap();// 把请求参数封装到Map<String, String[]>中
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> iter = properties.entrySet().iterator();
		String name = "";
		String value = "";
		while (iter.hasNext()) {
			Entry<String, String[]> entry = iter.next();
			name = entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) { // 用于请求参数中有多个相同名称
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();// 用于请求参数中请求参数名唯一
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}

}