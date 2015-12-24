package com.yanjiusuo.controller;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yanjiusuo.service.UserService;

@Controller
public class LoginController  extends MultiActionController{
	
    private final static Log logger = LogFactory.getLog(LoginController.class);
	
    @Autowired
	private UserService userService;
    
	/**
	 * 用户登录核对
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView userCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("application/json;charset=utf-8");
		
		Cookie cookie;
		boolean flag = false;
		PrintWriter pw = response.getWriter();
		String VerWrong="codewrong";
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String code=request.getParameter("code");
		String isAutoLogin=request.getParameter("isAutoLogin");
		
		HttpSession session = request.getSession();
		String rand = (String) session.getAttribute("verificationCode");
		
		if (code.equals(rand) == false) {
			pw.println("{\"jsonData\":\"" + VerWrong + "\"}");
		}else {
			try {
				flag=userService.userLogin(username, password);
				pw.println("{\"jsonData\":\"" + flag + "\"}");
				if (isAutoLogin.equals("checked") && true==flag) {
					cookie = new Cookie("autoLoginUser", "true"); 
					cookie.setMaxAge(60 * 60 * 24 * 14);  
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				
				if (true==flag) {
					cookie = new Cookie("autoLoginUser", "true"); 
					cookie.setMaxAge(60 * 60);  
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return null;
	}
}
