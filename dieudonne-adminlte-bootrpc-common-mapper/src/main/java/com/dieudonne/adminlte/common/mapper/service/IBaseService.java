package com.dieudonne.adminlte.common.mapper.service;

import java.util.List;

import com.dieudonne.adminlte.common.entity.response.ResultResponseEntity;
import com.dieudonne.adminlte.common.entity.response.StateAndMsgResponseEntity;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;


/**
 * 
 * @ClassName:  IBaseService   
 * @Description:通用接口   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 下午5:48:57   
 *   
 * @param <T>  
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface  IBaseService<T> {

	/**
	 * 
	 * @Title: save   
	 * @Description: 新增entity   
	 * @param: @param entity
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int save(T entity);
	

	/**
	 * 
	 * @Title: insertNotNull   
	 * @Description: 新增entity(不包含空字段)  
	 * @param: @param entity
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int saveNotNull(T entity);
	/**
	 * 
	 * @Title: updateByID   
	 * @Description: 更新entity(包含空字段)   
	 * @param: @param entity
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int updateByID(T entity);
	
	/**
	 * 
	 * @Title: updateByIDNotNull   
	 * @Description: 更新entity(不包含空字段)   
	 * @param: @param entity
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int updateByIDNotNull(T entity);

	/**
	 * 
	 * @Title: deleteByID   
	 * @Description: 根据主键删除   
	 * @param: @param key
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int deleteByID(Object key);
	
	/**
	 * 
	 * @Title: deleteByExample   
	 * @Description: 根据Example删除     
	 * @param: @param example
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int deleteByExample(Object example);
	
	/**
	 * 
	 * @Title: queryByID   
	 * @Description: 根据ID获取   
	 * @param: @param key
	 * @param: @return      
	 * @return: T      
	 * @throws
	 */
	public T queryByID(Object key);
	

	/**
	 * 
	 * @Title: queryList   
	 * @Description: 查询所有记录列表 (有条件)   
	 * @param: @param entity
	 * @param: @return      
	 * @return: List<T>      
	 * @throws
	 */
	public List<T> queryList(T entity);

	/**
	 * 
	 * @Title: queryOne   
	 * @Description: 查询单条记录     
	 * @param: @param entity
	 * @param: @return      
	 * @return: T      
	 * @throws
	 */
	public T queryOne(T entity);
	
	/**
	 * 
	 * @Title: queryOneByExample   
	 * @Description: 查询单条记录  
	 * @param: @param example
	 * @param: @return      
	 * @return: T      
	 * @throws
	 */
	public T queryOneByExample(Object example);
	
	/**
	 * 
	 * @Title: queryCount   
	 * @Description: count   
	 * @param: @param entity
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int queryCount(T entity) ;

	/**
	 * 
	 * @Title: queryByExample   
	 * @Description: 查询所有记录列表 (有条件)   
	 * @param: @param example
	 * @param: @return      
	 * @return: List<T>      
	 * @throws
	 */
	public List<T> queryByExample(Object example);
	
	/**
	 * 
	 * @Title: queryAll   
	 * @Description: 查询所有记录列表 (无条件)
	 * @param: @return      
	 * @return: List<T>      
	 * @throws
	 */
	public List<T> queryAll();
	
	/**
	 * 
	 * @Title: queryPage   
	 * @Description: 所有数据PageUtil对象
	 * @param: @param page
	 * @param: @param entity
	 * @param: @return      
	 * @return: PageUtil<T>      
	 * @throws
	 */
	public PageUtil<T> queryPage(PageUtil<T> page, T entity) ;

	/**
	 * 
	 * @Title: queryByParams   
	 * @Description: 根据条件example查询PageUtil对象   
	 * @param: @param page
	 * @param: @param example
	 * @param: @return      
	 * @return: PageUtil<T>      
	 * @throws
	 */
	public PageUtil<T> queryByExample(PageUtil<T> page, Object example) ;
	

	/**
	 * 
	 * @Title: commonSave   
	 * @Description: 通用新增entity方法  
	 * @param: @param entity
	 * @param: @return      
	 * @return: ResultResponseEntity<StateAndMsgResponseEntity>      
	 * @throws
	 */
	public ResultResponseEntity<StateAndMsgResponseEntity> commonSave(T entity);
	
	/**
	 * 
	 * @Title: commonSave   
	 * @Description: 通用新增entity方法 (不包含空字符串)
	 * @param: @param entity
	 * @param: @return      
	 * @return: ResultResponseEntity<StateAndMsgResponseEntity>      
	 * @throws
	 */
	public ResultResponseEntity<StateAndMsgResponseEntity> commonSaveNotNull(T entity);
	
	/**
	 * 
	 * @Title: commonUpdate   
	 * @Description: 通用根据主键更新entity方法    
	 * @param: @param entity
	 * @param: @return      
	 * @return: ResultResponseEntity<StateAndMsgResponseEntity>      
	 * @throws
	 */
	public ResultResponseEntity<StateAndMsgResponseEntity> commonUpdate(T entity);
	
	/**
	 * 
	 * @Title: commonUpdate   
	 * @Description: 通用根据主键更新entity方法    
	 * @param: @param entity
	 * @param: @return      
	 * @return: ResultResponseEntity<StateAndMsgResponseEntity>      
	 * @throws
	 */
	public ResultResponseEntity<StateAndMsgResponseEntity> commonUpdateNotNull(T entity);
	
	/**
	 * 
	 * @Title: commonDeleteByID   
	 * @Description: 通用删除方法   
	 * @param: @param keyID
	 * @param: @return      
	 * @return: ResultResponseEntity<StateAndMsgResponseEntity>      
	 * @throws
	 */
	public ResultResponseEntity<StateAndMsgResponseEntity> commonDeleteByID(Object keyID);
	
	/**
	 * 
	 * @Title: commonQueryPage   
	 * @Description: 所有数据ResultResponseEntity<PageUtil<T>>通用对象
	 * @param: @param page
	 * @param: @param entity
	 * @param: @return      
	 * @return: ResultResponseEntity<PageUtil<T>>    
	 * @throws
	 */
	public ResultResponseEntity<PageUtil<T>> commonQueryPage(PageUtil<T> page, T entity);
	
	/**
	 * 
	 * @Title: commonQueryByParams   
	 * @Description: 根据条件example通用查询ResultResponseEntity<PageUtil<T>>对象   
	 * @param: @param page
	 * @param: @param example
	 * @param: @return      
	 * @return: ResultResponseEntity<PageUtil<T>>      
	 * @throws
	 */
	public ResultResponseEntity<PageUtil<T>>  commonQueryByParams(PageUtil<T> page, Object example);

}
