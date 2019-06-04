package com.dieudonne.adminlte.model.blog;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
@Data
public class AppBlogCatalog implements Serializable {
	@Id
	private Long id;

    private String name;

    private Long userId;

    private Integer state;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

}