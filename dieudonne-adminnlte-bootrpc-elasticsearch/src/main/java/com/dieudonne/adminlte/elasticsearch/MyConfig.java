package com.dieudonne.adminlte.elasticsearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dieudonne.adminlte.bootrpc.elasticsearh.service.EsBlogService;
import com.dieudonne.adminlte.elasticsearch.service.EsBlogServiceImpl;

@Configuration
public class MyConfig{
	@Bean("esBlogService")
	public EsBlogService esBlogService()
	{
		return new EsBlogServiceImpl();
	}
}
