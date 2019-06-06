package com.dieudonne.adminlte.bootrpc.web.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

import com.dieudonne.adminlte.bootrpc.web.consumer.common.utils.SpringUtil;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableHystrix
@EnableConfigurationProperties
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
// springboot启动
@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.dieudonne.adminlte.bootrpc.web.consumer")
@ImportResource("classpath:dubbo-web-consumer.xml")
public class SystemConsumerApplication {
	// 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例  
    @Autowired  
    private RestTemplateBuilder builder;  
  
   // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例  
    @Bean  
    public RestTemplate restTemplate() {  
        return builder.build();  
    }  
	
    @Bean
	public ServletListenerRegistrationBean<SpringUtil> servletListenerRegistrationBean(){
		ServletListenerRegistrationBean<SpringUtil> servletListenerRegistrationBean = new ServletListenerRegistrationBean<SpringUtil>();
		servletListenerRegistrationBean.setListener(new SpringUtil());
		return servletListenerRegistrationBean;
	}
    
	public static void main(String[] args) {

		SpringApplication.run(SystemConsumerApplication.class, args);
	}
}
