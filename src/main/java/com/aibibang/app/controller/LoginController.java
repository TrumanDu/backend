package com.aibibang.app.controller;

import com.aibibang.app.common.base.BaseController;
import com.aibibang.app.common.constant.SessionAttr;
import com.aibibang.app.common.util.MenuUtils;
import com.aibibang.app.domain.SysMenu;
import com.aibibang.app.domain.SysUser;
import com.aibibang.app.service.SysMenuService;
import com.aibibang.app.service.SysUserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller 
@RequestMapping("/login")
public class LoginController extends BaseController {

	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysMenuService sysMenuService;
	
	/**
	 * 验证用户
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/checkUser")
	@ResponseBody
	public String checkUser(SysUser user, HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		try {
			
			SysUser u = sysUserService.findByUsername(user);
			
			if(u != null){
				if(!u.getPassword().equals(user.getPassword())){
					return json.toString();
				}
				HttpSession session = request.getSession();
				session.setAttribute(SessionAttr.USER_LOGIN.getValue(), u);
				List<Long> userMenus = sysUserService.findMenuIdByUserId(u.getId());
				List<SysMenu> menuList = sysMenuService.getByParentId(0L);
				session.setAttribute(SessionAttr.USER_MENUS.getValue(), MenuUtils.getMenu(menuList, userMenus));
				logger.info("login success");
				json.put("result", "login_success");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return json.toString();
	}
	
	/**
	 * 登出
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		session.removeAttribute(SessionAttr.USER_LOGIN.getValue());
		session.removeAttribute(SessionAttr.USER_ROLES.getValue());
		session.removeAttribute(SessionAttr.USER_MENUS.getValue());
		
		return "login";
	}

}
