package com.dieudonne.adminlte.model.system;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;

@Data
public class SysRoleMenu implements Serializable {
    public static final long serialVersionUID = 5029490745879546290L;
	
    @Id
    private String id;

    private String roleid;

    private String menuid;
}