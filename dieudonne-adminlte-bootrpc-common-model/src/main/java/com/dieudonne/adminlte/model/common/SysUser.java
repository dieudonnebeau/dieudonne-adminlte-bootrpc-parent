package com.dieudonne.adminlte.model.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
@Data
public class SysUser implements Serializable {
    public static final long serialVersionUID = -2779359599377864280L;
    public static final int _0 = 0;
	public static final int _1 = 1;
	@Id
	private String id;

    private String username;

    private String password;

    private Integer userstate;

    private Date createtime;

    private String userdesc;

    private String userimg;

    private String deptid;
}