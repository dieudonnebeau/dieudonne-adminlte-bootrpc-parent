package com.dieudonne.adminlte.elasticsearch.service;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.search.aggregations.AggregationBuilders.terms;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.search.SearchParseException;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.bootrpc.elasticsearh.service.EsBlogService;
import com.dieudonne.adminlte.bootrpc.elasticsearh.service.model.EsBlog;
import com.dieudonne.adminlte.bootrpc.elasticsearh.service.vo.TagVO;
import com.dieudonne.adminlte.elasticsearch.repository.es.EsBlogRepository;

/**
 * 
 * @ClassName:  EsBlogServiceImpl   
 * @Description:EsBlog 服务.  
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2019年5月31日 上午11:13:36   
 *     
 * @Copyright: 2019 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = EsBlogServiceImpl.BEAN_NAME)
public class EsBlogServiceImpl implements EsBlogService {
	public final static String BEAN_NAME = "esBlogService";
	@Autowired
	private EsBlogRepository esBlogRepository;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	private static final Pageable TOP_5_PAGEABLE = PageRequest.of(0, 5);
	private static final String EMPTY_KEYWORD = "";

	@Override
	public void removeEsBlog(String id) {
		esBlogRepository.deleteById(id);
	}

	@Override
	public EsBlog updateEsBlog(EsBlog esBlog) {
		return esBlogRepository.save(esBlog);
	}

	@Override
	public EsBlog getEsBlogByBlogId(Long blogId) {
		return esBlogRepository.findByBlogId(blogId);
	}

	@Override
	public Page<EsBlog> listNewestEsBlogs(String keyword, Pageable pageable) throws SearchParseException {
		Page<EsBlog> pages = null;
		Sort sort = new Sort(Direction.DESC, "createTime");
		if (pageable.getSort().isUnsorted()) {
			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
		}

		pages = esBlogRepository.findByTitleContainingOrSummaryContainingOrContentContainingOrTagsContaining(
				keyword, keyword, keyword, keyword, pageable);

		return pages;
	}

	@Override
	public Page<EsBlog> listHotestEsBlogs(String keyword, Pageable pageable) throws SearchParseException {

		Sort sort = new Sort(Direction.DESC, "readSize", "commentSize", "voteSize", "createTime");
		if (pageable.getSort().isUnsorted()) {
			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
		}

		return esBlogRepository.findByTitleContainingOrSummaryContainingOrContentContainingOrTagsContaining(
				keyword, keyword, keyword, keyword, pageable);
	}

	@Override
	public Page<EsBlog> listEsBlogs(Pageable pageable) {
		return esBlogRepository.findAll(pageable);
	}

	/**
	 * 最新前5
	 * 
	 * @param keyword
	 * @return
	 */
	@Override
	public List<EsBlog> listTop5NewestEsBlogs() {
		Page<EsBlog> page = this.listHotestEsBlogs(EMPTY_KEYWORD, TOP_5_PAGEABLE);
		return page.getContent();
	}

	/**
	 * 最热前5
	 * 
	 * @param keyword
	 * @return
	 */
	@Override
	public List<EsBlog> listTop5HotestEsBlogs() {
		Page<EsBlog> page = this.listHotestEsBlogs(EMPTY_KEYWORD, TOP_5_PAGEABLE);
		return page.getContent();
	}

	@Override
	public List<TagVO> listTop30Tags() {

		List<TagVO> list = new ArrayList<>();
		
		// 查询条件
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery())
				.withSearchType(SearchType.QUERY_THEN_FETCH).withIndices("blog").withTypes("blog")
				.addAggregation(terms("tags").field("tags")
				.order(Terms.Order.count(false)).size(30)).build();
		
		// 聚合
		Aggregations aggregations = elasticsearchTemplate.query(searchQuery,
				new ResultsExtractor<Aggregations>() {
			@Override
			public Aggregations extract(SearchResponse response) {
				return response.getAggregations();
			}
		});

		StringTerms modelTerms = (StringTerms) aggregations.asMap().get("tags");
		// 升级到 Spring Boot 2.0.1 之后，使用新的方法
//		Iterator<Bucket> modelBucketIt = modelTerms.getBuckets().iterator();
//		while (modelBucketIt.hasNext()) {
//			Bucket actiontypeBucket = modelBucketIt.next();
//
//			list.add(new TagVO(actiontypeBucket.getKey().toString(), actiontypeBucket.getDocCount()));
//		}
		
		List<StringTerms.Bucket> modelBucketIt =  modelTerms.getBuckets();
		for (StringTerms.Bucket actiontypeBucket : modelBucketIt) {
			list.add(new TagVO(actiontypeBucket.getKeyAsString(), actiontypeBucket.getDocCount()));
		}
		
		return list;
	}

	@Override
	public List<String> listTop12Users() {

		List<String> usernamelist = new ArrayList<>();// 存储排序后的用户账号
		
		// 查询条件
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery())
				.withSearchType(SearchType.QUERY_THEN_FETCH).withIndices("blog").withTypes("blog")
				.addAggregation(terms("users").field("username")
				.order(Terms.Order.count(false)).size(12)).build();
		// 聚合
		Aggregations aggregations = elasticsearchTemplate.query(searchQuery, 
				new ResultsExtractor<Aggregations>() {
			@Override
			public Aggregations extract(SearchResponse response) {
				return response.getAggregations();
			}
		});

		StringTerms modelTerms = (StringTerms) aggregations.asMap().get("users");
		
		// 升级到 Spring Boot 2.0.1 之后，使用新的方法
//		Iterator<Bucket> modelBucketIt = modelTerms.getBuckets().iterator();
//		while (modelBucketIt.hasNext()) {
//			Bucket actiontypeBucket = modelBucketIt.next();
//			String username = actiontypeBucket.getKey().toString();
//			usernamelist.add(username);
//		}
		
		List<StringTerms.Bucket> modelBucketIt =  modelTerms.getBuckets();
		for (StringTerms.Bucket actiontypeBucket : modelBucketIt) {
			String username = actiontypeBucket.getKeyAsString();
			usernamelist.add(username);
		}
		
		return usernamelist;
	}
}
