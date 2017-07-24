package com.aibibang.app.controller;

import com.aibibang.app.common.base.BaseController;
import com.aibibang.app.common.constant.SessionAttr;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

	private Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping("")
	public String login(String theme,HttpServletRequest request){
		
		String userMenu = (String)request.getSession().getAttribute(SessionAttr.USER_MENUS.getValue());
		request.setAttribute("menus", userMenu);
		
		logger.info("login success");

		return "index";
	}
	
	
	@RequestMapping("/icon")
	public String icon(HttpServletRequest request){
		
		return "/system/icon/icon";
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request){
		return "workspace";
	}
}
