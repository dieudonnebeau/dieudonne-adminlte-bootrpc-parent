package com.dieudonne.adminlte.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@EnableConfigurationProperties
// springboot启动
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) 
@SpringBootApplication
@ComponentScan("com.dieudonne.adminlte.elasticsearch")
@ImportResource("classpath:dubbo-es-provider.xml")
public class ElasticsearchApplication {
	

	public static void main(String[] args) { 
		SpringApplication.run(ElasticsearchApplication.class, args);
	}
}
