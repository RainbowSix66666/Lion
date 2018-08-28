package com.rainbowsix.cbec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class CheckLoginInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean result = false;		
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		
		System.out.println("interceptor is work");
		
		if(session.getAttribute("userInfo") != null) {
			result = true;
		}
		if(!result) {
			response.sendRedirect(contextPath + "login.html");
			System.out.println(contextPath);
		}			
		
		return result;
	}
}
