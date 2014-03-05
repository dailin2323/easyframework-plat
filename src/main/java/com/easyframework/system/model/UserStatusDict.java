package com.easyframework.system.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.easyframework.core.base.BaseDict;

/**
 * 
 * @Title: UserStatusDict.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午4:01:35
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午4:01:35
 */
@Entity
@Table(name = "ZKM_USER_STATUS_DICT")
@DynamicInsert(true)
@DynamicUpdate(true)
public class UserStatusDict extends BaseDict {
	
	public static final int TYPE_UNDREDGE = 1;	//未开通
	public static final int TYPE_ACTIVE = 2;	//有效
	public static final int TYPE_FORBIDDEN = 3;	//禁用
	public static final int TYPE_DELETE = 4;	//删除

	public UserStatusDict(){
	}
	
	public UserStatusDict(String name, int type){
		super(name, type);
	}
	
	public UserStatusDict(String name, String code, int type){
		super(name, code ,type);
	}
	
}
