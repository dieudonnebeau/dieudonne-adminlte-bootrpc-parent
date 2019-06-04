package com.dieudonne.adminlte.common.mapper.ds;

import java.io.Serializable;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "jdbc")
@Data
public class JdbcDatasources implements Serializable{  
	public static final long serialVersionUID = -1861073824224416513L;
	private String[] datasources ;
	
	private Map<String, Object> ds;
	private Map<String, Object> ds1;
	private Map<String, Object> ds2;
}
