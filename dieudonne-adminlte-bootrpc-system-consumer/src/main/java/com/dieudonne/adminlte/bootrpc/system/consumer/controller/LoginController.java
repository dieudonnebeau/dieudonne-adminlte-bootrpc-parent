package com.dieudonne.adminlte.bootrpc.system.consumer.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.dieudonne.adminlte.bootrpc.system.consumer.common.controller.SuperController;
import com.dieudonne.adminlte.bootrpc.system.service.ISysLogService;
import com.dieudonne.adminlte.common.mapper.model.SysUser;
import com.google.code.kaptcha.servlet.KaptchaExtend;

/**
 * 
 * @ClassName:  LoginController   
 * @Description:登录控制器  
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月30日 下午5:15:11   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/login")
public class LoginController extends SuperController {
	/**
	 * 日志服务
	 */
	@Resource
	private ISysLogService sysLogService;
	
	/**
	 * 登录页面
	 */
	@RequestMapping
	public String login(Model model){
		return "login";
	}
	
	/**
	 * 执行登录
	 */
    @RequestMapping(value = "/doLogin",method=RequestMethod.POST)  
    public  String doLogin(String userName,String password, String captcha,String return_url,RedirectAttributesModelMap model){
		
    	Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		
		 if (!currentUser.isAuthenticated()) {
	          // token.setRememberMe(true);
	            try {
	                currentUser.login(token);
	            } catch (UnknownAccountException uae) {
	            	
	            	model.addFlashAttribute("error", "Utilisateur inconnu");
	            	return redirectTo("/login");
	            } catch (IncorrectCredentialsException ice) {
	            	model.addFlashAttribute("error", "Erreur de mot de passe");
	            	return redirectTo("/login");
	            } catch (LockedAccountException lae) {
	            	model.addFlashAttribute("error", "Le compte est verrouillé.");
	            	return redirectTo("/login");
	            }
	            catch (AuthenticationException ae) {
	                //unexpected condition?  error?
	            	model.addFlashAttribute("error", "Le serveur est occupé");
	            	return redirectTo("/login");
	            }
	        }
		/**
		 * 记录登录日志
		 */
		 Subject subject = SecurityUtils.getSubject();
		 SysUser sysUser = (SysUser) subject.getPrincipal();
		 sysLogService.insertLog("Le succès de connexion",sysUser.getUsername(),request.getRequestURI(),"");
		 return redirectTo("/");
    }  
	
    /**
     * 验证码
     */
    @RequestMapping("/captcha")
	@ResponseBody
    public  void captcha() throws ServletException, IOException{
		KaptchaExtend kaptchaExtend =  new KaptchaExtend();
		kaptchaExtend.captcha(request, response);
    }
}
