package com.yanjiusuo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yanjiusuo.util.CookieUtil;

public class OnlineFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 2488019693265931560L;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
	    String path = req.getContextPath();
	    String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path;
		
	    Cookie cookie=CookieUtil.getCookieByName(req, "autoLoginUser");
		boolean flag=false;

		if (cookie!=null && (cookie.getValue()).equals("true")) {
	            flag=true;
	    }
         
    	if (true==flag) {
    		chain.doFilter(req, resp);
		}
    	else {
			resp.sendRedirect(basePath+"/login.jsp");
		}  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
