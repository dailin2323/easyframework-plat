package com.easyframework.system.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @Title: LayoutAction.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午3:58:03
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午3:58:03
 */
@Controller
@RequestMapping("/layout")
public class LayoutAction {
	
	@RequestMapping("/index")
	public String index(){
		return "/layout/index";
	}
	
	@RequestMapping("/north")
	public String north(){
		return "/layout/north";
	}
	
	@RequestMapping("/south")
	public String south(){
		return "/layout/south";
	}
	
	@RequestMapping("/west")
	public String west(){
		return "/layout/west";
	}
	
	@RequestMapping("/east")
	public String east(){
		return "/layout/east";
	}
	
	@RequestMapping("/center")
	public String center(){
		return "/layout/center";
	}
}
