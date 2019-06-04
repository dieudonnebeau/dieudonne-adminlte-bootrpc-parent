package com.dieudonne.adminlte.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * @ClassName:  ObjectMapperConfig   
 * @Description:ObjectMapperConfig   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年4月22日 上午10:11:55   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
public class ObjectMapperConfig{
  @Bean
  public ObjectMapper ObjectMapper(){
   ObjectMapper objectMapper=new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);;
   return objectMapper;
  }
}