package com.dieudonne.adminlte.model.system;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;
@Data
public class SysMenu implements Serializable { 
	public static final long serialVersionUID = 9171589415250880391L;
	@Id
	private String id;

    private String menuname;

    private String pid;

    private String url;

    private String icon;

    private Integer sort;

    private Integer deep;

    private String code;

    private String resource;
}