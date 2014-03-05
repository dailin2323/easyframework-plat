package com.easyframework.system.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyframework.core.easyUI.DataGridParam;
import com.easyframework.core.pageModel.AjaxResult;
import com.easyframework.system.service.RoleService;

/**
 * 
 * @Title: RoleAction.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午3:58:17
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午3:58:17
 */
@Controller
@RequestMapping("/role")
public class RoleAction {
	@Resource
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping("/getRoles")
	public AjaxResult getRoles(DataGridParam dataGridParam){
		AjaxResult j = new AjaxResult();
		j.setSuccess(true);
		j.setMsg("操作成功");
		j.setData(roleService.getDataGrid(dataGridParam), null, null);
		return j;
	}
	
	@RequestMapping("/roleManagerUI")
	public String roleManagerUI(){
		return "/role/roleManager";
	}
	
	
	
	
	
	
	
}
