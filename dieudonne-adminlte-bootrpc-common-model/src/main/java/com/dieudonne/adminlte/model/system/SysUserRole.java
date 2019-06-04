package com.dieudonne.adminlte.model.system;

import java.io.Serializable;

//import javax.persistence.Id;

import lombok.Data;

@Data
public class SysUserRole implements Serializable {
    public static final long serialVersionUID = 5120999119519230616L;
//    @Id
	private String id;

    private String userid;

    private String roleid;
}