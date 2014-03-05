package com.easyframework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyframework.core.easyUI.DataGrid;
import com.easyframework.core.easyUI.DataGridParam;
import com.easyframework.system.dao.RoleDao;
import com.easyframework.system.model.Role;
import com.easyframework.system.service.RoleService;

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
public class RoleServiceImpl implements RoleService{

	@Resource
	private RoleDao roleDao;
	
	@Override
	public DataGrid getDataGrid(DataGridParam dataGridParam) {
		return roleDao.getDataGrid(dataGridParam, null, null, null, null);
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll(null, null);
	}

	@Override
	public void delete(Role role) {
		roleDao.delete(role);
	}

	@Override
	public void save(Role role) {
		roleDao.save(role);
		
	}

}
