package com.dieudonne.adminlte.bootrpc.blog.consumer.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dieudonne.adminlte.bootrpc.blog.consumer.common.utils.SpringUtil;
import com.dieudonne.adminlte.bootrpc.system.service.ISysMenuService;
import com.dieudonne.adminlte.bootrpc.system.service.ISysSettingService;
import com.dieudonne.adminlte.common.mapper.model.SysUser;
import com.dieudonne.adminlte.common.mapper.util.ShiroUtil;
import com.dieudonne.adminlte.model.system.SysSetting;
import com.dieudonne.adminlte.system.vo.TreeMenu;


/**
 * 
 * @ClassName:  GlobalInterceptor   
 * @Description:全局拦截器   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月28日 上午9:32:02   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
//@Component
public class GlobalInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	ISysSettingService settingsService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (handler instanceof HandlerMethod) {
			
			/**
			 * 加载全局非登录访问常量
			 */
			List<SysSetting> list =  ((ISysSettingService)SpringUtil.getBean("settingService")).findAll();
			for(SysSetting setting : list){
				request.setAttribute(setting.getSyskey(),setting.getSysvalue());
			}
			
			/**
			 * 保存登录信息
			 */
			SysUser me = ShiroUtil.getSessionUser();
			if(me == null){
				return true;
			}
			me.setPassword("");
			request.setAttribute("me", me);
			/**
			 * 资源和当前选中菜单
			 */
			String res = request.getParameter("p");
			if (StringUtils.isNotBlank(res)) {
				request.getSession().setAttribute("res", res);
			}
			String cur = request.getParameter("t");
			if (StringUtils.isNotBlank(cur)) {
				request.getSession().setAttribute("cur", cur);
			}
			/**
			 * 获取当前用户的菜单
			 */
			List<TreeMenu> treeMenus = SpringUtil.getBean(ISysMenuService.class).selectTreeMenuByUserId(me.getId());
			request.setAttribute("treeMenus", treeMenus);
			
		}

		/**
		 * 通过拦截
		 */
		return true;
	}

}
