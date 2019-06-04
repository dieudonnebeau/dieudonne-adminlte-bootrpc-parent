package com.dieudonne.adminlte.model.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
@Data
public class SysRole implements Serializable {  
	public static final long serialVersionUID = 5770721576939014994L;
	@Id
	private String id;

    private String rolename;

    private String roledesc;

    private Integer rolestate;

    private Date createtime;
}