package com.dieudonne.adminlte.bootrpc.elasticsearh.service.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.dieudonne.adminlte.model.blog.AppBlog;
import com.dieudonne.adminlte.model.common.SysUser;

//import org.springframework.data.elasticsearch.annotations.Mapping;

/**
 * EsBlog 文档类.
 * 
 * @since 1.0.0 2017年3月5日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Document(indexName = "blog", type = "blog")
//@Mapping(mappingPath = "blog_mapping.json")
public class EsBlog implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Id  // 主键
	private String id;  
	@Field(type = FieldType.Long)    
	private Long blogId; // Blog 实体的 id
	@Field(type = FieldType.Long)
	private Long userId;
	@Field(type = FieldType.Long)
    private Long catalogId;
	@Field(type = FieldType.text)     
	private String title;
	@Field(type = FieldType.text)  
	private String summary;
	@Field(type = FieldType.text)  
	private String content;
	@Field(type = FieldType.keyword, index = false)  // 不做全文检索字段  
	private String username;
	@Field(type = FieldType.text,index = false)  // 不做全文检索字段  
	private String avatar;
	@Field(type = FieldType.Date,index = false)  // 不做全文检索字段  
	private Timestamp createTime;
	@Field(type = FieldType.Date,index = false)  // 不做全文检索字段  
	private Timestamp updateTime;
	@Field(type = FieldType.Integer,index = false)  // 不做全文检索字段  
	private Integer readSize = 0; // 访问量、阅读量
	@Field(type = FieldType.Integer,index = false)  // 不做全文检索字段  
	private Integer commentSize = 0;  // 评论量
	@Field(type = FieldType.Integer,index = false)  // 不做全文检索字段  
	private Integer voteSize = 0;  // 点赞量
	@Field(type = FieldType.text,fielddata=true, searchAnalyzer = "ik_smart", analyzer = "ik_smart") 
	private String tags;  // 标签

	protected EsBlog() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用 
	}

	public EsBlog(Long blogId,Long userId,Long catalogId, String title, String summary, String content,
			String username, String avatar,Timestamp createTime,
			Integer readSize,Integer commentSize, Integer voteSize , String tags) {
		this.blogId = blogId;
		this.userId = userId;
		this.catalogId = catalogId;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.username = username;
		this.avatar = avatar;
		this.createTime = createTime;
		this.readSize = readSize;
		this.commentSize = commentSize;
		this.voteSize = voteSize;
		this.tags = tags;
	}
	
	public EsBlog(AppBlog blog, SysUser user){
		this.blogId = blog.getId();
		this.userId = blog.getId();
		this.catalogId = blog.getCatalogId();
		this.title = blog.getTitle();
		this.summary = blog.getSummary();
		this.content = blog.getContent();
		this.username = user.getUsername();
		this.avatar = user.getUserimg();
		this.createTime = (Timestamp) blog.getCreateTime();
		this.updateTime = (Timestamp) blog.getUpdateTime();
		this.readSize = blog.getReadSize();
		this.commentSize = blog.getCommentSize();
		this.voteSize = blog.getVoteSize();
		this.tags = blog.getTags();
	}
 
	public void update(AppBlog blog, SysUser user){
		this.blogId = blog.getId();
		this.userId = blog.getId();
		this.catalogId = blog.getCatalogId();
		this.title = blog.getTitle();
		this.summary = blog.getSummary();
		this.content = blog.getContent();
		this.username = user.getUsername();
		this.avatar = user.getUserimg();
		this.createTime = (Timestamp) blog.getCreateTime();
		this.updateTime = (Timestamp) blog.getUpdateTime();
		this.readSize = blog.getReadSize();
		this.commentSize = blog.getCommentSize();
		this.voteSize = blog.getVoteSize();
		this.tags = blog.getTags();
	}
 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
 
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
 
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getReadSize() {
		return readSize;
	}

	public void setReadSize(Integer readSize) {
		this.readSize = readSize;
	}

	public Integer getCommentSize() {
		return commentSize;
	}

	public void setCommentSize(Integer commentSize) {
		this.commentSize = commentSize;
	}

	public Integer getVoteSize() {
		return voteSize;
	}

	public void setVoteSize(Integer voteSize) {
		this.voteSize = voteSize;
	}

	public String getTags() {
		return tags;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
    public String toString() {
        return String.format(
                "EsBlog[blogId=%d, title='%s', summary='%s']",
                blogId, title, summary);
    }
}
