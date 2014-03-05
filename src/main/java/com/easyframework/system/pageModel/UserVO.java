package com.easyframework.system.pageModel;

import java.util.Date;

import com.easyframework.core.util.DateUtil;

/**
 * 
 * @Title: UserVO.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午4:02:02
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午4:02:02
 */
public class UserVO {
	private Long id;				//用户标识
	private String name;			//用户名（登录名）
	private String nickName;		//昵称
	private String realName;		//真实姓名
	
	private Byte sex;				//性别
	private Integer age;			//年龄
	private String userStatus;		//帐号状态
	private String avatar;			//头像
	private String birthday;
	//private Adress adress;			//地址 
	//private Set<Role> roles = new LinkedHashSet<Role>();	//角色集
	//private Set<Group> groups = new LinkedHashSet<Group>();	//组集
	
	
	//--------------getter setter------------
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
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = DateUtil.formateToYYMDHMS(birthday);
	}
	
}
