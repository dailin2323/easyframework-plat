package com.easyframework.system.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @Title: Role.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午4:01:20
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午4:01:20
 */
@Entity
@Table(name = "ZKM_ROLE")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "id", unique = true, nullable = false, length = 36)
	private Long id;		//id
	private String name;	//角色名称
	private String remark;	//角色描述
	
	@JSONField(serialize=false)
	@ManyToMany(cascade={CascadeType.REFRESH})   
	@JoinTable(name = "ZKM_RESOURCE_ROLE", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "RESOURCE_ID") })
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("id")
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private Set<Resource> resources = new LinkedHashSet<Resource>();
	
	@JSONField(serialize=false)
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new LinkedHashSet<User>();
	
	//-----------------getter setter-----------------
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<Resource> getResources() {
		return resources;
	}
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
