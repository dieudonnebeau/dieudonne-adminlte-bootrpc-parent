package com.dieudonne.adminlte.bootrpc.blog.consumer.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpHelper {

	/**
	 * 
	 * @Title: getHttpServletRequest   
	 * @Description:  获取 HttpServletRequest  
	 * @param: @return      
	 * @return: HttpServletRequest      
	 * @throws
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

}
