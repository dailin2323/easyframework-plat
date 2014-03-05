package com.easyframework.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 
 * @Title: Adress.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午4:00:55
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午4:00:55
 */
@Entity
@Table(name = "ZKM_ADRESS")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Adress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "id", unique = true, nullable = false, length = 36)
	private Long id;
	
	private String name;
	
	private String remark;

//	private Adress parent;
//	private Set<Adress> children;
	
	//-----------getter setter------------
	
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
	
	

	
}
