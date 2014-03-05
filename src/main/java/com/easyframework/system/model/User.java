package com.easyframework.system.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.alibaba.fastjson.annotation.JSONField;
import com.easyframework.core.util.MD5Util;

/**
 * 
 * @Title: User.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午4:01:27
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午4:01:27
 */
@Entity
@Table(name = "ZKM_USER")
@DynamicInsert(true)
@DynamicUpdate(true)
public class User {
	private static final String NAME_OF_ADMIN = "admin"; 
	
	//用户标识
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "id", unique = true, nullable = false, length = 36)
	private Long id;				
	
	//用户名（登录名）
	@Column(unique = true, nullable = false, length = 20)
	private String name;			
	
	//密码(MD5加密)
	@Column(unique = true, nullable = false, length = 32)
	private String password;		
	
	//昵称
	@Column(nullable = false, length = 20)
	private String nickName;	
	
	//真实姓名
	@Column(unique = true, nullable = false, length = 20)
	private String realName;		
	
	//性别
	@Column(nullable = false)
	private Byte sex;				
	
	//年龄
	@Column(nullable = false)
	private Integer age;			
	
	//出生年月
	//@JSONField(format="YYYY-MM-DD")
	private Date birthday;			
	
	//帐号状态
	@ManyToOne
	@JoinColumn(name="userStatusDict_id")
	private UserStatusDict userStatusDict;	
	
	//头像
	@Column(length = 40)
	private String avatar;			
	
//	private Adress adress;			//地址 
	
	@JSONField(serialize=false)
	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(cascade={CascadeType.REFRESH},fetch = FetchType.EAGER)   
	@JoinTable(name = "ZKM_USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private Set<Role> roles = new LinkedHashSet<Role>();	//角色集
	
	@JSONField(serialize=false)
	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(cascade={CascadeType.REFRESH},fetch = FetchType.EAGER)   
	@JoinTable(name = "ZKM_USER_GROUP", joinColumns = { @JoinColumn(name = "USER_id") }, inverseJoinColumns = { @JoinColumn(name = "GROUP_ID") })
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private Set<Group> groups = new LinkedHashSet<Group>();	//组集

	/**
	 * @Description: 判断user是否是管理员
	 * @param ：参数
	 * @return:返回
	 * @throws :抛出异常
	 */
	public boolean isAdmin() {
		if (this.getName().equals(NAME_OF_ADMIN)) {
			return true;
		} else {
			return false;
		}
	}

	//--------------getter setter----------------
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public UserStatusDict getUserStatusDict() {
		return userStatusDict;
	}

	public void setUserStatusDict(UserStatusDict userStatusDict) {
		this.userStatusDict = userStatusDict;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = MD5Util.md5(password);
	}

}
