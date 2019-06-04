package com.dieudonne.adminlte.system.service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.dieudonne.adminlte.bootrpc.system.service.IAppNewsService;
import com.dieudonne.adminlte.common.mapper.service.impl.BaseServiceImpl;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.model.system.AppNews;
import com.dieudonne.adminlte.system.mapper.AppNewsMapper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * 
 * @ClassName:  SysDeptServiceImpl   
 * @Description:SysDept 表数据服务层接口实现类   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月28日 上午10:53:39   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service(value = AppNewsServiceImpl.BEAN_NAME)
public class AppNewsServiceImpl extends BaseServiceImpl<AppNewsMapper, AppNews> implements IAppNewsService {
	public final static String BEAN_NAME = "appNewsService";

	@Override
	public PageUtil<AppNews> queryPage(PageUtil<AppNews> page, String search) {
		Example example = new Example(AppNews.class);
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(search)){
			criteria.andLike("title","%"+search+"%");
		}
		return queryByExample(page, example);
	}

}