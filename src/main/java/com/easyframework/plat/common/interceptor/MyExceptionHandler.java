package com.easyframework.plat.common.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.easyframework.core.exception.ActionException;
import com.easyframework.core.exception.BaseException;
import com.easyframework.core.exception.DaoException;
import com.easyframework.core.exception.ServiceException;
import com.easyframework.core.pageModel.AjaxResult;
import com.easyframework.core.util.ActionUtil;

/**
 * 
 * @Title: MyExceptionHandler.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2014-3-5 下午4:08:32
 * @最后修改人：邹凯明
 * @最后修改时间：2014-3-5 下午4:08:32
 */
public class MyExceptionHandler implements HandlerExceptionResolver {
	protected final Logger logger = Logger.getLogger(MyExceptionHandler.class);
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		boolean isAjaxRequest = ActionUtil.isAjaxRequst(request);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("error", ex);
		String errorMsg = "未知错误！";
		if (ex.getMessage() != null || !"".equals(ex.getMessage().trim())) {
			errorMsg = ex.getMessage().trim();
		}
		//判断异常
		if (ex instanceof DaoException) {
		// 1 处理Dao层运行时异常
			// 1.1 Hibernate 运行时异常
			// 1.2 JDBC 运行时异常
			errorMsg = "Dao层异常:" + errorMsg;
		} else if (ex instanceof ServiceException) {
		// 2 Service层运行时异常
			errorMsg = "Service层异常:" + errorMsg;

		} else if (ex instanceof ActionException) {
		// 3 Control层运行时异常
			errorMsg = "Control层异常:" + errorMsg;
		} else if (ex instanceof BaseException) {
		// 4 系统运行时异常
			errorMsg = "系统异常:" + errorMsg;
		} else if (ex instanceof RuntimeException) {
		// 5 其他运行时异常
			errorMsg = "位置的运行时异常:" + errorMsg;
		} else {
		// 6 未知严重错误
			errorMsg = "未知的严重错误:" + errorMsg;
		}
		
		//记录日志
		logger.error(errorMsg, ex);
		
		//ajax的请求的处理方式
		if(isAjaxRequest){
			AjaxResult j = new AjaxResult();
			j.setSuccess(false);
			j.setMsg(errorMsg);
			j.setData(ex);
			
			String json = JSON.toJSONStringWithDateFormat(j, "yyyy-MM-dd HH:mm:ss");
			// String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat);
			response.setContentType("text/html;charset=utf-8");
			
			try {
				response.getWriter().write(json);
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}else{
			//非ajax请求的处理方式
			request.setAttribute("msg", errorMsg);
			request.setAttribute("data", ex);
			
			return new ModelAndView("/error/500", model);
		}	
	}
	
}
