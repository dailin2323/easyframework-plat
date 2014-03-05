package com.easyframework.system.service;

import java.util.List;

import com.easyframework.core.easyUI.Tree;
import com.easyframework.core.easyUI.TreeGrid;
import com.easyframework.core.easyUI.TreeGridParam;
import com.easyframework.core.easyUI.TreeParam;
import com.easyframework.system.model.Resource;


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
public interface ResourceService {
	List<Tree> getTree(TreeParam treeParam);
	TreeGrid getTreeGrid(TreeGridParam treeGridParam);
	List<Resource> findAll();
	void delete(Resource resource);
	void save(Resource resource);
}
