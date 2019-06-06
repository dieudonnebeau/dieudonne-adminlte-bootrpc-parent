package com.dieudonne.adminlte.bootrpc.elasticsearh.service;
 

import java.util.List;

import org.springframework.data.domain.Page;
import com.dieudonne.adminlte.bootrpc.elasticsearh.service.model.EsBlog;
import com.dieudonne.adminlte.bootrpc.elasticsearh.service.vo.TagVO;

/**
 * EsBlog 服务接口.
 * 
 * @since 1.0.0 2017年6月8日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface EsBlogService {
 	
	/**
	 * 删除EsBlog
	 * @param id
	 * @return
	 */
	void removeEsBlog(String id);
	
	/**
	 * 更新 EsBlog
	 * @param EsBlog
	 * @return
	 */
	EsBlog updateEsBlog(EsBlog esBlog);
	
	/**
	 * 根据Blog的Id获取EsBlog
	 * @param id
	 * @return
	 */
	EsBlog getEsBlogByBlogId(Long blogId);
 
	/**
	 * 最新博客列表，分页
	 * @param keyword
	 * @param pageable
	 * @return
	 */
	Page<EsBlog> listNewestEsBlogs(String keyword,  int pageIndex, int pageSize, String direction);
 
	/**
	 * 最热博客列表，分页
	 * @param keyword
	 * @param pageable
	 * @return
	 */
	Page<EsBlog> listHotestEsBlogs(String keyword, int pageIndex, int pageSize, String direction);
	
	/**
	 * 博客列表，分页
	 * @param pageable
	 * @return
	 */
	Page<EsBlog> listEsBlogs(int pageIndex, int pageSize);
	/**
	 * 最新前5
	 * @param keyword
	 * @return
	 */
	List<EsBlog> listTop5NewestEsBlogs();
	
	/**
	 * 最热前5
	 * @param keyword
	 * @return
	 */
	List<EsBlog> listTop5HotestEsBlogs();
	
	/**
	 * 最热前 30 标签
	 * @return
	 */
	List<TagVO> listTop30Tags();

	/**
	 * 最热前12用户
	 * @return
	 */
	List<String> listTop12Users();
}
