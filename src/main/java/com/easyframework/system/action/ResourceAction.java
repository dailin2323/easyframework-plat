package com.easyframework.system.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyframework.core.base.BaseAction;
import com.easyframework.core.easyUI.Tree;
import com.easyframework.core.easyUI.TreeGrid;
import com.easyframework.core.easyUI.TreeGridParam;
import com.easyframework.core.easyUI.TreeParam;
import com.easyframework.system.service.ResourceService;

/**
 * 
 * @Title: ResourceAction.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午3:58:11
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午3:58:11
 */
@Controller
@RequestMapping("/resource")
public class ResourceAction extends BaseAction {
		
	@Resource
	private ResourceService resourceService;
	
	/** 同步方法 */
	public String resourceMangerUI(){
		return "/resource/resouceManager";
	}
	
	
	/** 异步方法 */
	@RequestMapping("/getTree")
	@ResponseBody
	public List<Tree> getTree(TreeParam treeParam){
		List<Tree> trees = null; 
	
		trees = resourceService.getTree(treeParam);
		logger.info("成功读取资源树");
	
		return trees;
	}
	
	@ResponseBody
	@RequestMapping("/getResourceList")
	public TreeGrid getResourceList(TreeGridParam treeGridParam) {
		TreeGrid dataGrid = resourceService.getTreeGrid(treeGridParam);
		logger.info("查询用户列表成功!");
		return dataGrid;
	}
	
	
}
