package com.dieudonne.adminlte.common.entity.response;

import java.io.Serializable;
import java.util.List;

public class ClassifyResponse implements Serializable {
    private Integer id;

    private String name;

    private Integer parentId;

    private String picPath;

    private String state;

    private String createTime;

    private String remark;

    private String storeId;

    private String attr3;

    private String level;
    
    private List<ClassifyResponse> children;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParent_id(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3 == null ? null : attr3.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }
    
    

    public List<ClassifyResponse> getChildren() {
		return children;
	}

	public void setChildren(List<ClassifyResponse> children) {
		this.children = children;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", parent_id=").append(parentId);
        sb.append(", picPath=").append(picPath);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", remark=").append(remark);
        sb.append(", storeId=").append(storeId);
        sb.append(", attr3=").append(attr3);
        sb.append(", level=").append(level);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}