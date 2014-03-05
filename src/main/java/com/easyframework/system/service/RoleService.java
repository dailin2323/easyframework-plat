package com.easyframework.system.service;

import java.util.List;

import com.easyframework.core.easyUI.DataGrid;
import com.easyframework.core.easyUI.DataGridParam;
import com.easyframework.system.model.Role;


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
public interface RoleService {
	DataGrid getDataGrid(DataGridParam dataGridParam);
	List<Role> findAll();
	void delete(Role role);
	void save(Role role);
}

