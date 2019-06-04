package com.dieudonne.adminlte.system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.bootrpc.system.service.ISysMenuService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.model.system.SysMenu;
import com.dieudonne.adminlte.model.system.SysRole;
import com.dieudonne.adminlte.system.mapper.SysMenuMapper;
import com.dieudonne.adminlte.system.mapper.SysRoleMenuMapper;
import com.dieudonne.adminlte.system.vo.TreeMenu;
import com.dieudonne.adminlte.system.vo.TreeMenuAllowAccess;
import com.google.common.collect.Lists;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * 
 * @ClassName:  SysMenuServiceImpl   
 * @Description:SysMenu 表数据服务层接口实现类   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月28日 上午10:56:18   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = SysMenuServiceImpl.BEAN_NAME)
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
	public final static String BEAN_NAME = "menuService";
	/**
	 * 菜单服务
	 */
	@Autowired private SysMenuMapper sysMenuMapper;
	/**
	 * 角色菜单关系服务
	 */
	@Autowired private SysRoleMenuMapper sysRoleMenuMapper;
	

	@Cacheable(value = "permissionCache", key = "#uid")
	@Override
	public List<String> selectMenuIdsByuserId(String uid) {
		return sysMenuMapper.selectMenuIdsByuserId(uid);
	}

	
	@Cacheable(value = "menuCache", key = "#uid")
	@Override
	public List<TreeMenu> selectTreeMenuByUserId(String uid) {
		/**
		 * 当前用户二级菜单权限
		 */
		List<String> menuIds = sysRoleMenuMapper.selectRoleMenuIdsByUserId(uid);
		return selectTreeMenuByMenuIdsAndPid(menuIds, "0");
	}
	
	@Override
	public List<TreeMenu> selectTreeMenuByMenuIdsAndPid(final List<String> menuIds,String pid) {
		// TODO Auto-generated method stub
		//根据pid 字段 和 id)
		Example example = new Example(SysMenu.class);
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("sort ASC");
		criteria.andEqualTo("pid", pid);
		criteria.andIn("id", menuIds.size() > 0 ? menuIds : Lists.newArrayList(RandomStringUtils.randomNumeric(30)));
		List<SysMenu> sysMenus = this.queryByExample(example);
		List<TreeMenu> treeMenus = new ArrayList<TreeMenu>();
		for(SysMenu sysMenu : sysMenus){
			TreeMenu treeMenu = new TreeMenu();
			treeMenu.setSysMenu(sysMenu);
			if(sysMenu.getDeep() < 2){
				treeMenu.setChildren(selectTreeMenuByMenuIdsAndPid(menuIds,sysMenu.getId()));
			}
			treeMenus.add(treeMenu);
		}
		return treeMenus;
	}
	
	
	@Override
	public List<TreeMenuAllowAccess> selectTreeMenuAllowAccessByMenuIdsAndPid(
			final List<String> menuIds, String pid) {
		// TODO Auto-generated method stub
		Example example = new Example(SysMenu.class);
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("sort ASC");
		criteria.andEqualTo("pid", pid);
		List<SysMenu> sysMenus = this.queryByExample(example);		
		List<TreeMenuAllowAccess> treeMenuAllowAccesss = new ArrayList<TreeMenuAllowAccess>();
		for(SysMenu sysMenu : sysMenus){
			TreeMenuAllowAccess treeMenuAllowAccess = new TreeMenuAllowAccess();
			treeMenuAllowAccess.setSysMenu(sysMenu);
			/**
			 * 是否有权限
			 */
			if(menuIds.contains(sysMenu.getId())){
				treeMenuAllowAccess.setAllowAccess(true);
			}
			/**
			 * 子节点
			 */
			if(sysMenu.getDeep() < 3){
				treeMenuAllowAccess.setChildren(selectTreeMenuAllowAccessByMenuIdsAndPid(menuIds,sysMenu.getId()));
			}
			treeMenuAllowAccesss.add(treeMenuAllowAccess);
		}
		return treeMenuAllowAccesss;
	}


	@Override
	public PageUtil<SysMenu> queryPage(PageUtil<SysMenu> page, String menuname) {
		Example example = new Example(SysRole.class);
		Example.Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(menuname)){
			criteria.andLike("menuName", "%"+menuname+"%");
		}
		return queryByExample(page, example);
	}


	@Override
	public List<SysMenu> queryListByPid(String pid) {
		Example example = new Example(SysMenu.class);
		example.setOrderByClause("code ASC");
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("pid",pid);
		return queryByExample(example);
	}


	@Override
	public List<SysMenu> queryListByResource(String resource) {
    	Example example = new Example(SysMenu.class);
		example.setOrderByClause("sort ASC");
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("resource",resource);
		return queryByExample(example);
	}

}