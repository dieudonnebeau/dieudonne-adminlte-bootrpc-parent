package com.dieudonne.adminlte.model.blog;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import com.dieudonne.adminlte.model.common.SysUser;

import lombok.Data;
@Data
public class AppBlog implements Serializable {
	@Id
	private Long id;

    private Long userId;

    private Long catalogId;

    private String title;

    private String summary;

    private String tags;

    private Integer readSize;

    private Integer commentSize;

    private Integer voteSize;

    private Integer state;

    private Date createTime;

    private Date updateTime;
    
    private String content;

    private String htmlContent;
    
    

    private static final long serialVersionUID = 1L;
}