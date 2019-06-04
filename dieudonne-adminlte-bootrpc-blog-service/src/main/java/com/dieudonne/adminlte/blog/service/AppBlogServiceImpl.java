package com.dieudonne.adminlte.blog.service;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.blog.mapper.AppBlogMapper;
import com.dieudonne.adminlte.bootrpc.blog.service.IAppBlogService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.model.blog.AppBlog;


/**
 * 
 * @ClassName:  AppBlogServiceImpl   
 * @Description:博客业务逻辑   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2019年5月30日 下午2:44:06   
 *     
 * @Copyright: 2019 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = AppBlogServiceImpl.BEAN_NAME)
public class AppBlogServiceImpl extends BaseServiceImpl<AppBlogMapper, AppBlog> implements IAppBlogService {
	public final static String BEAN_NAME = "appBlogService";

}