package com.easyframework.system.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OrderBy;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @Title: Resource.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午4:01:12
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午4:01:12
 */
@Entity
@Table(name = "ZKM_RESOURCE")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	private Long id;
	
	private String name;
	
	private String url;
	
	private String remark;
	
	private String icon;
	
	private Long serialNo;
	//private int temp
	
	@JSONField(serialize=false)
	@ManyToOne(fetch = FetchType.LAZY)		//取出
	private Resource parent;
	
	@JSONField(serialize=false)
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")	//取出
	@OrderBy(clause = "serialNo asc")
	private Set<Resource> children = new LinkedHashSet<Resource>();
	
	@JSONField(serialize=false)
	@ManyToMany(mappedBy="resources")
	private Set<Role> roles = new LinkedHashSet<Role>(); 
	// aaa/bbb/c?a=0&b=2
	
	public Resource(){
		
	}
	
	public Resource(String name, String icon, String url, long serialNo, Resource parent){
		this.name = name;
		this.icon = icon;
		this.url = url;
		this.serialNo = serialNo;
		this.parent = parent;
	}
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Resource getParent() {
		return parent;
	}
	public void setParent(Resource parent) {
		this.parent = parent;
	}
	public Set<Resource> getChildren() {
		return children;
	}
	public void setChildren(Set<Resource> children) {
		this.children = children;
	}
	public Long getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}











