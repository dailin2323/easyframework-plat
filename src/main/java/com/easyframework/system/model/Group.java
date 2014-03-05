package com.easyframework.system.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @Title: Group.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午4:01:06
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午4:01:06
 */
@Entity
@Table(name = "ZKM_GROUP")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Group {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	private Long id;
	
	private String name;
	
	private String remark;
	
	@JSONField(serialize=false)
	@ManyToMany(mappedBy = "groups")
	private Set<User> users = new LinkedHashSet<User>();
	
	//--------getter setter----------
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
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
