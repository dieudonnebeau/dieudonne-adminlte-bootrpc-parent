package com.dieudonne.adminlte.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.dieudonne.adminlte.common.mapper.ds.DynamicDataSourceRegister;



/**
 * 
 * @ClassName:  RxmallMarketServiceProviderAPP   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年4月20日 下午3:01:37   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@EnableConfigurationProperties
@EnableAutoConfiguration
// 扫描mapper
@MapperScan(basePackages = "com.dieudonne.adminlte.system.mapper")
// 启动注册动态数据源been
@Import({ DynamicDataSourceRegister.class })
// springboot启动
@SpringBootApplication
@ComponentScan("com.dieudonne.adminlte.system")
@ImportResource("classpath:dubbo-provider.xml")
public class SystemServiceApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(SystemServiceApplication.class, args);
	}

}
