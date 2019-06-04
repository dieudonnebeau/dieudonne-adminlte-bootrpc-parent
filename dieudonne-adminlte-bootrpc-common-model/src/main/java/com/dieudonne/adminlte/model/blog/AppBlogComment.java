package com.dieudonne.adminlte.model.blog;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;

@Data
public class AppBlogComment implements Serializable {
	@Id
	private Long id;

    private Long userId;

    private Long blogId;

    private String content;

    private Integer state;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

}