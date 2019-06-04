package com.dieudonne.adminlte.model.system;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;

@Data
public class SysSetting implements Serializable {
    public static final long serialVersionUID = -6440573038283221054L;
    @Id
	private String id;

    private String syskey;

    private String sysname;

    private String sysvalue;

    private Integer sort;

    private String sysdesc;
}