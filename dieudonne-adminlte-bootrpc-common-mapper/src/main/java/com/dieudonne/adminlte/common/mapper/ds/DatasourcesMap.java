package com.dieudonne.adminlte.common.mapper.ds;

import java.io.Serializable;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "spring")
@Data
public class DatasourcesMap implements Serializable{  
	public static final long serialVersionUID = -4561073824224416513L;
	private Map<String, Object> datasource;
}
