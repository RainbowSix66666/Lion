package com.rainbowsix.cbec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class UserLoginCheckedInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = false;
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") == null) {
			String path = request.getContextPath() + "/ldj-login.html";
			
			response.sendRedirect(path);
		}else {
			result = true;
		}
		return result;
		
		
//		System.out.println(path);
		
		
	}
	
	
	
}
