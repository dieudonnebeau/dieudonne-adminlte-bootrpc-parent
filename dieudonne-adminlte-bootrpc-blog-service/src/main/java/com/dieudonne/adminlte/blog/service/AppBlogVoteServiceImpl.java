package com.dieudonne.adminlte.blog.service;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.blog.mapper.AppBlogVoteMapper;
import com.dieudonne.adminlte.bootrpc.blog.service.IAppBlogVoteService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.model.blog.AppBlogVote;


/**
 * 
 * @ClassName:  AppBlogVoteServiceImpl   
 * @Description:博客点赞业务  
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2019年5月30日 下午2:49:55   
 *     
 * @Copyright: 2019 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = AppBlogVoteServiceImpl.BEAN_NAME)
public class AppBlogVoteServiceImpl extends BaseServiceImpl<AppBlogVoteMapper, AppBlogVote> implements IAppBlogVoteService {
	public final static String BEAN_NAME = "appBlogVoteService";

}