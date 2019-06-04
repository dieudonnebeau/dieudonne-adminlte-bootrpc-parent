package com.dieudonne.adminlte.model.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;

@Data
public class AppNews implements Serializable {
	 public static final long serialVersionUID = 1L;
	 @Id
	 private String id;

    private String title;

    private String subtitle;

    private String authorId;

    private String classifyId;

    private String typeId;

    private String sammary;

    private String link;

    private String coverImage;

    private Integer readNumber;

    private Date createTime;

    private Date updateTime;

    private Integer topState;

    private Integer state;

    private String content;
}