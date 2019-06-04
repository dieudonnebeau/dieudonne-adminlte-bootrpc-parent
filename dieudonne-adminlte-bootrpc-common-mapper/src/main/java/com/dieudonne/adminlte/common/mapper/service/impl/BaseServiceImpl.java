package com.dieudonne.adminlte.common.mapper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dieudonne.adminlte.common.entity.response.ResultResponseEntity;
import com.dieudonne.adminlte.common.entity.response.StateAndMsgResponseEntity;
import com.dieudonne.adminlte.common.enums.CommonEnum;
import com.dieudonne.adminlte.common.mapper.dao.BaseMapper;
import com.dieudonne.adminlte.common.mapper.service.IBaseService;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.common.util.BlankUtil;
import com.github.pagehelper.page.PageMethod;

import tk.mybatis.mapper.common.Mapper;

public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> implements IBaseService<T> {	
	@Autowired
	protected Mapper<T> mapper;

	public Mapper<T> getMapper() {
		return mapper;
	}
	
	/**
	 * 
	 * @Title: save   
	 * @Description: 新增entity   
	 * @param: @param entity
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int save(T entity) {
		return mapper.insert(entity);
	}
	

	/**
	 * 
	 * @Title: insertNotNull   
	 * @Description: 新增entity(不包含空字段)  
	 * @param: @param entity
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int saveNotNull(T entity) {
		return mapper.insertSelective(entity);
	}
	/**
	 * 
	 * @Title: updateByID   
	 * @Description: 更新entity(包含空字段)   
	 * @param: @param entity
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int updateByID(T entity) {
		return mapper.updateByPrimaryKey(entity);
	}
	
	/**
	 * 
	 * @Title: updateByIDNotNull   
	 * @Description: 更新entity(不包含空字段)   
	 * @param: @param entity
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int updateByIDNotNull(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}
	

	/**
	 * 
	 * @Title: deleteByID   
	 * @Description: 根据主键删除   
	 * @param: @param key
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int deleteByID(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}
	
	/**
	 * 
	 * @Title: deleteByExample   
	 * @Description: 根据Example删除     
	 * @param: @param example
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int deleteByExample(Object example) {
		return mapper.deleteByExample(example);
	}

	
	public T queryByID(Object key) {
		return mapper.selectByPrimaryKey(key);
	}
	

	public List<T> queryList(T entity) {
		return mapper.select(entity);
	}

	public T queryOne(T entity) {
		return mapper.selectOne(entity);
	}
	
	public T queryOneByExample(Object example) {
		List<T> list = queryByExample(example);
		if(BlankUtil.isBlank(list)) {
			return null;
		}else {
			return list.get(0);
		}
	}

	public int queryCount(T entity) {
		return mapper.selectCount(entity);
	}

	public List<T> queryByExample(Object example) {
		return mapper.selectByExample(example);
	}

	public List<T> queryAll() {
		return mapper.selectAll();
	}
	
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
	public PageUtil<T> queryPage(PageUtil<T> page, T entity) {
		PageMethod.startPage(page.getPageNo(), page.getPageSize());
		List<T> list = queryList(entity);
		return new PageUtil<T>(list);
	}

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
	public PageUtil<T> queryByExample(PageUtil<T> page, Object example) {
		PageMethod.startPage(page.getPageNo(), page.getPageSize());
		List<T> list = queryByExample(example);
		return new PageUtil<T>(list);
	}
	
	

	/**
	 * 
	 * @Title: commonSave   
	 * @Description: 通用新增entity方法  
	 * @param: @param entity
	 * @param: @return      
	 * @return: ResultResponseEntity<StateAndMsgResponseEntity>      
	 * @throws
	 */
	public ResultResponseEntity<StateAndMsgResponseEntity> commonSave(T entity) {
		int result = save(entity);
		if (result <= 0) {
			return ResultResponseEntity.fail(
					new StateAndMsgResponseEntity(CommonEnum.SAVE_FAIL.getState(), CommonEnum.SAVE_FAIL.getMessage()));
		} else {
			return ResultResponseEntity.success(
					new StateAndMsgResponseEntity(CommonEnum.SAVE_SUCCESS.getState(), CommonEnum.SAVE_SUCCESS.getMessage()));
		}
	}
	
	/**
	 * 
	 * @Title: commonSave   
	 * @Description: 通用新增entity方法 (不包含空字符串)
	 * @param: @param entity
	 * @param: @return      
	 * @return: ResultResponseEntity<StateAndMsgResponseEntity>      
	 * @throws
	 */
	public ResultResponseEntity<StateAndMsgResponseEntity> commonSaveNotNull(T entity) {
		int result = saveNotNull(entity);
		if (result <= 0) {
			return ResultResponseEntity.fail(
					new StateAndMsgResponseEntity(CommonEnum.SAVE_FAIL.getState(), CommonEnum.SAVE_FAIL.getMessage()));
		} else {
			return ResultResponseEntity.success(
					new StateAndMsgResponseEntity(CommonEnum.SAVE_SUCCESS.getState(), CommonEnum.SAVE_SUCCESS.getMessage()));
		}
	}
	
	/**
	 * 
	 * @Title: commonUpdate   
	 * @Description: 通用根据主键更新entity方法    
	 * @param: @param entity
	 * @param: @return      
	 * @return: ResultResponseEntity<StateAndMsgResponseEntity>      
	 * @throws
	 */
	public ResultResponseEntity<StateAndMsgResponseEntity> commonUpdate(T entity) {
		int result = updateByID(entity);
		if (result <= 0) {
			return ResultResponseEntity.fail(
					new StateAndMsgResponseEntity(CommonEnum.UPDATE_FAIL.getState(), CommonEnum.UPDATE_FAIL.getMessage()));
		} else {
			return ResultResponseEntity.success(
					new StateAndMsgResponseEntity(CommonEnum.UPDATE_SUCCESS.getState(), CommonEnum.UPDATE_SUCCESS.getMessage()));
		}
	}
	
	/**
	 * 
	 * @Title: commonUpdate   
	 * @Description: 通用根据主键更新entity方法    
	 * @param: @param entity
	 * @param: @return      
	 * @return: ResultResponseEntity<StateAndMsgResponseEntity>      
	 * @throws
	 */
	public ResultResponseEntity<StateAndMsgResponseEntity> commonUpdateNotNull(T entity) {
		int result = updateByIDNotNull(entity);
		if (result <= 0) {
			return ResultResponseEntity.fail(
					new StateAndMsgResponseEntity(CommonEnum.UPDATE_FAIL.getState(), CommonEnum.UPDATE_FAIL.getMessage()));
		} else {
			return ResultResponseEntity.success(
					new StateAndMsgResponseEntity(CommonEnum.UPDATE_SUCCESS.getState(), CommonEnum.UPDATE_SUCCESS.getMessage()));
		}
	}
	
	/**
	 * 
	 * @Title: commonDeleteByID   
	 * @Description: 通用删除方法   
	 * @param: @param keyID
	 * @param: @return      
	 * @return: ResultResponseEntity<StateAndMsgResponseEntity>      
	 * @throws
	 */
	public ResultResponseEntity<StateAndMsgResponseEntity> commonDeleteByID(Object keyID) {
		int result = deleteByID(keyID);
		if (result <= 0) {
			return ResultResponseEntity.fail(
					new StateAndMsgResponseEntity(CommonEnum.DELETE_FAIL.getState(), CommonEnum.DELETE_FAIL.getMessage()));
		} else {
			return ResultResponseEntity.success(
					new StateAndMsgResponseEntity(CommonEnum.DELETE_SUCCESS.getState(), CommonEnum.DELETE_SUCCESS.getMessage()));
		}
	}
	
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
	public ResultResponseEntity<PageUtil<T>> commonQueryPage(PageUtil<T> page, T entity) {
		PageMethod.startPage(page.getPageNo(), page.getPageSize());
		List<T> list = queryList(entity);
		return ResultResponseEntity.success((new PageUtil<T>(list)));
	}
	
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
	public ResultResponseEntity<PageUtil<T>>  commonQueryByParams(PageUtil<T> page, Object example) {
		PageMethod.startPage(page.getPageNo(), page.getPageSize());
		List<T> list = queryByExample(example);
		return ResultResponseEntity.success((new PageUtil<T>(list)));
	}

}
