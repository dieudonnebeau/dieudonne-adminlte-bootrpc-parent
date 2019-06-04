package com.dieudonne.adminlte.bootrpc.system.service;


import java.util.Map;

import com.dieudonne.adminlte.common.mapper.model.SysUser;
import com.dieudonne.adminlte.common.mapper.service.IBaseService;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;


/**
 * 
 * @ClassName:  ISysUserService   
 * @Description:SysUser 表数据服务层接口   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 下午5:38:40   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface ISysUserService extends IBaseService<SysUser> {	
	
	
	SysUser queryByUsername(String username);
	/**
	 * 
	 * @Title: insertUser   
	 * @Description: 保存用户  
	 * @param: @param user
	 * @param: @param roleId      
	 * @return: void      
	 * @throws
	 */
	void insertUser(SysUser user, String[] roleId);
	/**
	 * 
	 * @Title: updateUser   
	 * @Description: 更新用户   
	 * @param: @param sysUser
	 * @param: @param roleId      
	 * @return: void      
	 * @throws
	 */
	void updateUser(SysUser sysUser, String[] roleId);
	/**
	 * 
	 * @Title: delete   
	 * @Description: 删除用户   
	 * @param: @param id      
	 * @return: void      
	 * @throws
	 */
	void delete(String id);
	
	/**
	 * 
	 * @Title: selectUserPage   
	 * @Description: 根据用户名username获取用户列表(带分页)   
	 * @param: @param page
	 * @param: @param username
	 * @param: @return      
	 * @return: PageUtil<Map<Object,Object>>      
	 * @throws
	 */
	PageUtil<Map<Object, Object>> selectUserPage(PageUtil<SysUser> page, String username);

}