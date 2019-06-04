package com.dieudonne.adminlte.model.system;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;

@Data
public class SysDept implements Serializable {   
	public static final long serialVersionUID = 1L;
	@Id
	private String id;

    private String deptname;

    private String deptdesc;

}