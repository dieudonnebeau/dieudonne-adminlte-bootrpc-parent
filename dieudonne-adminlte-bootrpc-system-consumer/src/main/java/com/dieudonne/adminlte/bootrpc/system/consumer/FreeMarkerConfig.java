package com.dieudonne.adminlte.bootrpc.system.consumer;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dieudonne.adminlte.bootrpc.system.consumer.common.shiro.tag.ShiroTags;


/**
 * 
 * @ClassName:  FreeMarkerConfig   
 * @Description:配置测试   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年12月10日 上午10:00:32   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    @PostConstruct
    public void setSharedVariable() {
    	try {
			configuration.setSharedVariable("shiro", new ShiroTags());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
