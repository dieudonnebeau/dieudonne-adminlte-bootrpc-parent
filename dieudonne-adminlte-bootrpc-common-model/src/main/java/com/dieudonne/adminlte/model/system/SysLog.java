package com.dieudonne.adminlte.model.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
@Data
public class SysLog implements Serializable {  
	public static final long serialVersionUID = 4403920449892155550L;
	@Id
	private String id;

    private String username;

    private String title;

    private String url;

    private Date createtime;

    private String params;
}