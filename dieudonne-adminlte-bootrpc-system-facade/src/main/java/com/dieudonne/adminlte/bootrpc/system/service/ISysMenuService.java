package com.dieudonne.adminlte.bootrpc.system.service;

import java.util.List;

import com.dieudonne.adminlte.common.mapper.service.IBaseService;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.model.system.SysMenu;
import com.dieudonne.adminlte.system.vo.TreeMenu;
import com.dieudonne.adminlte.system.vo.TreeMenuAllowAccess;


/**
 * 
 * @ClassName:  ISysMenuService   
 * @Description:SysMenu 表数据服务层接口   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 下午5:47:39   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface ISysMenuService extends IBaseService<SysMenu> {

	/**
	 * 
	 * @Title: selectMenuIdsByuserId   
	 * @Description: 获取指定用户拥有的菜单   
	 * @param: @param uid
	 * @param: @return      
	 * @return: List<String>      
	 * @throws
	 */
	List<String> selectMenuIdsByuserId(String uid);
	/**
	 * 获取指定用户的菜单
	 * @param  menuIds 当前用户所在角色拥有的权限ID集合
	 * @param  pid 菜单父ID
	 */
	List<TreeMenu> selectTreeMenuByMenuIdsAndPid(List<String> menuIds, String pid);
	/**
	 * 
	 * @Title: selectTreeMenuByUserId   
	 * @Description: 获取当前用户的菜单 
	 * @param: @param uid
	 * @param: @return      
	 * @return: List<TreeMenu>      
	 * @throws
	 */
	List<TreeMenu> selectTreeMenuByUserId(String uid);
	/**
	 * 获取指定用户拥有权限
	 * @param  menuIds 该角色拥有的权限ID集合
	 * @param  pid 菜单父ID
	 */
	List<TreeMenuAllowAccess> selectTreeMenuAllowAccessByMenuIdsAndPid(List<String> menuIds, String pid);
	
	PageUtil<SysMenu> queryPage(PageUtil<SysMenu> page, String menuname);
	
	List<SysMenu> queryListByPid(String pid);
	
	List<SysMenu> queryListByResource(String resource);

}