package com.dieudonne.adminlte.bootrpc.system.service;

import java.util.List;
import java.util.Set;

import com.dieudonne.adminlte.common.mapper.service.IBaseService;
import com.dieudonne.adminlte.model.system.SysUserRole;


/**
 * 
 * @ClassName:  ISysUserRoleService   
 * @Description:SysUserRole 表数据服务层接口   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 下午5:39:08   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface ISysUserRoleService extends IBaseService<SysUserRole> {
	
	/**
	 * 
	 * @Title: findRolesByUid   
	 * @Description: 获取用户的角色  
	 * @param: @param uid
	 * @param: @return      
	 * @return: Set<String>      
	 * @throws
	 */
	Set<String> findRolesByUid(String uid);
	
	List<SysUserRole> queryListByUserId(String userId);
	
}