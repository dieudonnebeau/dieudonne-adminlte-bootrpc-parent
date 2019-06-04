package com.dieudonne.adminlte.bootrpc.blog.consumer.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * @ClassName: SpringUtil
 * @Description:Spring 工具类
 * @author: 湖南无为网电子商务有限公司 (Dieudonne)
 * @date: 2018年11月28日 上午9:27:04
 * 
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved.
 *             注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

public class SpringUtil implements ServletContextListener {

	private static WebApplicationContext springContext;

	public void contextInitialized(ServletContextEvent event) {
		springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
	}

	public void contextDestroyed(ServletContextEvent event) {

	}

	public static ApplicationContext getApplicationContext() {
		return springContext;
	}

	public SpringUtil() {
	}

	public static <T> T getBean(Class<T> requiredType) {

		if (springContext == null) {

			throw new RuntimeException("springContext is null.");
		}
		return springContext.getBean(requiredType);
	}

	public static Object getBean(String requiredType) {

		if (springContext == null) {

			throw new RuntimeException("springContext is null.");
		}
		return springContext.getBean(requiredType);
	}

}
