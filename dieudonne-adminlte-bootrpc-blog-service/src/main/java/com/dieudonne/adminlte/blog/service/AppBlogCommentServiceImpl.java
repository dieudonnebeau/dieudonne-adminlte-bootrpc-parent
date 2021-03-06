package com.dieudonne.adminlte.blog.service;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.blog.mapper.AppBlogCommentMapper;
import com.dieudonne.adminlte.bootrpc.blog.service.IAppBlogCommentService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.model.blog.AppBlogComment;


/**
 * 
 * @ClassName:  AppBlogCommentServiceImpl   
 * @Description:博客评论业务   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2019年5月30日 下午2:51:51   
 *     
 * @Copyright: 2019 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = AppBlogCommentServiceImpl.BEAN_NAME)
public class AppBlogCommentServiceImpl extends BaseServiceImpl<AppBlogCommentMapper, AppBlogComment> implements IAppBlogCommentService {
	public final static String BEAN_NAME = "appBlogCommentService";

}