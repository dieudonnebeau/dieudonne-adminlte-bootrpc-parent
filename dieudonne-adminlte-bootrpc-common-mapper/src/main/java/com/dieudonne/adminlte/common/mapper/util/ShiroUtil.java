package com.dieudonne.adminlte.common.mapper.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;

import com.dieudonne.adminlte.common.mapper.model.SysUser;


/**
 * 
 * @ClassName:  ShiroUtil   
 * @Description:Shiro工具类   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 上午10:42:13   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class ShiroUtil {

	/**
	 * 密码加密
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String md51024Pwd(String password,Object salt){
		return new SimpleHash("MD5", password, salt, 1024).toString();
	}
	
	/**
	 * 获取当前Session中的用户
	 * @return
	 */
	public static SysUser getSessionUser(){
		
		Subject subject = SecurityUtils.getSubject();
		if(subject != null){
			Object object = subject.getPrincipal();
			if(object != null){
				SysUser sysUser = (SysUser) object;
				return sysUser;
			}
		}
		return null;
	}
	
	/**
	 * 获取当前用户ID
	 * @return
	 */
	public static String getSessionUid(){
		
		SysUser sysUser = getSessionUser();
		
		if(sysUser != null){
			
			return sysUser.getId();
		}
		
		return null;
	}
}
