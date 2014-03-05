package com.easyframework.system.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import com.easyframework.core.config.DBConfig;
import com.easyframework.core.converter.ObjectToTreeConverter;
import com.easyframework.core.easyUI.Tree;
import com.easyframework.core.easyUI.TreeGrid;
import com.easyframework.core.easyUI.TreeGridParam;
import com.easyframework.core.easyUI.TreeParam;
import com.easyframework.system.dao.ResourceDao;
import com.easyframework.system.model.Resource;
import com.easyframework.system.service.ResourceService;

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
public class ResourceServiceImpl implements ResourceService{
	
	@javax.annotation.Resource
	private ResourceDao resourceDao;
	
	@Override
	public List<Tree> getTree(TreeParam treeParam){
		return resourceDao.getTree(treeParam, null, null, new Order[]{Order.asc(DBConfig.TABLE_SORT_FIELD)}, new ObjectToTreeConverter() {
			@Override
			public Tree convert(Object src) {
				Resource rescource = (Resource) src;
				Tree tree = new Tree();
				/*tree.setId(rescource.getId());
				tree.setText(rescource.getName());
				tree.setUrl(rescource.getUrl());
				if(rescource.getChildren() == null || rescource.getChildren().size() == 0){
					//tree.setChildren(null);
					tree.setState(Tree.NODE_STATE_OPEN);
				}*/
				return tree;
			}
		});
	}
	
	@Override
	public TreeGrid getTreeGrid(TreeGridParam treeGridParam){
		return resourceDao.getTreeGrid(treeGridParam, null,new Order[]{}, null, null);
	}

	@Override
	public List<Resource> findAll() {
		return resourceDao.findAll(null, null);
	}

	@Override
	public void delete(Resource resource) {
		resourceDao.delete(resource);
	}

	@Override
	public void save(Resource resource) {
		resourceDao.save(resource);
	}
}
