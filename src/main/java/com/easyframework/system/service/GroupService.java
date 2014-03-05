package com.easyframework.system.service;

import java.util.List;

import com.easyframework.system.model.Group;


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
public interface GroupService {
	
	List<Group> findAll();
	void delete(Group group);
	void save(Group group);
	
}
