package com.easyframework.system.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyframework.core.base.BaseAction;
import com.easyframework.core.easyUI.DataGrid;
import com.easyframework.core.easyUI.DataGridParam;
import com.easyframework.core.pageModel.AjaxResult;
import com.easyframework.core.util.ActionUtil;
import com.easyframework.system.model.User;
import com.easyframework.system.service.UserService;

/**
 * 
 * @Title: UserAction.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午3:58:31
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午3:58:31
 */
@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction{
	
	/** 依赖的Service */
	@Resource
	private UserService userService;
	
	/** 同步方法 */
	@RequestMapping("/loginUI")
	public String loginUI(){
		return "/user/login";
	}
	
	@RequestMapping("/regUI")
	public String regUI(){
		return "/user/reg";
	}
	
	@RequestMapping("/userManagerUI")
	public String userManagerUI(){
		return "/user/userManager";
	}
	
	
	/** 异步方法 */
	@ResponseBody
	@RequestMapping("/login")
	public AjaxResult login(User user) {
		AjaxResult j = new AjaxResult();
		/** 参数有效性检测  */
		if(user.getName() == null || user.getName().trim().equals("") ||
				user.getPassword() == null || user.getPassword().trim().equals("")){
			j.setMsg("用户名或密码不能为空");
			j.setSuccess(false);
			return j;
		}
		
		User curLoginUser = userService.login(user);
		if (curLoginUser == null) {
			j.setSuccess(false);
			j.setMsg("用户名或密码错误！");
			
			logger.info("用户:"+user.getName() +" 登录失败!");
		} else {
			j.setSuccess(true);
			j.setMsg("登录成功！");
			
			ActionUtil.setCurLoginUser(user);
			logger.info("用户:"+user.getName() +" 登录成功!");
		}
		return j;
	}

	@ResponseBody
	@RequestMapping("/logout")
	public AjaxResult logout() {
		AjaxResult j = new AjaxResult();
		ActionUtil.setCurLoginUser(null);
		j.setSuccess(true);
		j.setMsg("注销成功！");
		return j;
	}
	
	@ResponseBody
	@RequestMapping("/getUserList")
	public DataGrid getUserList(DataGridParam dataGridParam) {
		DataGrid dataGrid =userService.getDataGrid(dataGridParam);
		logger.info("查询用户列表成功!");
		return dataGrid;
	}
	
	@ResponseBody
	@RequestMapping("/reg")
	public AjaxResult reg(User user){
		AjaxResult j = new AjaxResult();
		/** 参数有效性检测  */
		if(user.getName() == null || user.getName().trim().equals("") ||
				user.getPassword() == null || user.getPassword().trim().equals("")){
			j.setMsg("用户名或密码不能为空");
			j.setSuccess(false);
			return j;
		}
		
		User dbUser = (User)userService.getByName(user.getName());
		if(dbUser != null){
			j.setSuccess(false);
			j.setMsg("该用户名已存在，请重新输入!");
			return j;
		}
		
		User regUser = userService.reg(user);
		j.setSuccess(true);
		j.setMsg("注册成功！");
		
		logger.info("用户:"+regUser.getName() +" 注册成功!");
		return j;
	}
	
	@RequestMapping("/getUserManagerUI")
	public String getUserManagerUI(){
		return "/user/userManager";
	}
	

}
