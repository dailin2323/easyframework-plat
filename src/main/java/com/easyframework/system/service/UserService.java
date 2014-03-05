package com.easyframework.system.service;

import java.util.List;

import com.easyframework.core.easyUI.DataGrid;
import com.easyframework.core.easyUI.DataGridParam;
import com.easyframework.system.model.User;

/**
 * @Title: Adress.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2013-12-18 下午10:42:07
 * @最后修改人：邹凯明
 * @最后修改时间：2013-12-18 下午10:42:07
 * @version V1.0
 * @copyright: 
 */
public interface UserService {
	
	/** 用户登录
	 * @param user
	 * @return
	 */
	User login(User user);
	
	/**用户注册
	 * @param user
	 * @return
	 */
	User reg(User user);
	
	/**
	 * 更新用户
	 */
	void update(User user);
	
	/**
	 * 删除用户
	 */
	void delete(User user);
	

	DataGrid getDataGrid(DataGridParam dataGridParam);
	
	User getByName(String name);
	
	List<User> findAll();
	
	
}
