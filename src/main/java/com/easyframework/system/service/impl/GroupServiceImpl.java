package com.easyframework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyframework.system.dao.GroupDao;
import com.easyframework.system.model.Group;
import com.easyframework.system.service.GroupService;

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
public class GroupServiceImpl implements GroupService{

	@Resource
	private GroupDao groupDao;
	
	@Override
	public List<Group> findAll() {
		return groupDao.findAll(null, null);
	}

	@Override
	public void delete(Group group) {
		groupDao.delete(group);
	}

	@Override
	public void save(Group group) {
		groupDao.save(group);	
	}
	
	

}
