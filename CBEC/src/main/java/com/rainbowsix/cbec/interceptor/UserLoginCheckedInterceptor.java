package com.rainbowsix.cbec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class UserLoginCheckedInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
		if(true) {
			System.out.println("in true");
			
			String path = request.getContextPath() + "/ldj-login.html";
			System.out.println(path);
			response.sendRedirect(path);
		}
		return false;
	}
}
