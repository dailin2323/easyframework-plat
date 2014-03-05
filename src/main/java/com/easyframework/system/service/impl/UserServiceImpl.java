package com.easyframework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import com.easyframework.core.easyUI.DataGrid;
import com.easyframework.core.easyUI.DataGridParam;
import com.easyframework.system.dao.UserDao;
import com.easyframework.system.model.User;
import com.easyframework.system.service.UserService;

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

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	@Override
	public User login(User user){
		if(user.getName() == null || user.getName().trim().equals("") ||
				user.getPassword() == null || user.getPassword().trim().equals("")){
			return null;
		}
		User dbUser = (User) userDao.getByName(user.getName(), null, null);
		if (dbUser != null) {
			if(dbUser.getPassword().equals(user.getPassword())){
				return dbUser;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	@Override
	public User reg(User user){
		userDao.save(user);
		return user;
	}
	
	@Override
	public void update(User user) {
		if(user != null){
			userDao.update(user);
		}
	}

	@Override
	public void delete(User user) {
		if(user != null){
			userDao.delete(user);
		}
	}

	@Override
	public DataGrid getDataGrid(DataGridParam dataGridParam) {
		return userDao.getDataGrid(dataGridParam, null,new Order[]{}, null, null);
	}

	@Override
	public User getByName(String name) {
		return (User) userDao.getByName(name, null, null);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll(null, null);
	}

	

	
}
