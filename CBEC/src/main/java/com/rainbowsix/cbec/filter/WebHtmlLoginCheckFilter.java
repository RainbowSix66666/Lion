package com.rainbowsix.cbec.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class WebHtmlLoginCheckFilter
 */
@WebFilter("*.html")
public class WebHtmlLoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WebHtmlLoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		//取得web站点的名称
		String webRoot = req.getServletContext().getContextPath();
		String url = req.getRequestURI();
		if(url.equals(webRoot+"/login.html")) {
			chain.doFilter(request, response);
		}else{
			HttpSession session = req.getSession();
			if(session.getAttribute("userInfo") == null) {
				res.sendRedirect(webRoot+"/login.html");
			}else {
				chain.doFilter(request, response);
			}
			
		}
	
		/*HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		//取得web站点的名称
		String webRoot = req.getServletContext().getContextPath();
		String url = req.getRequestURI();
		if(url.equals(webRoot+"/login.html")) {
			chain.doFilter(request, response);
		}
		else {
			HttpSession session = req.getSession();
			if(session.getAttribute("userInfo")!=null) {
				
				chain.doFilter(request, response);
			}
			else{
				res.sendRedirect(webRoot+"/login.html");
			}
			
		}*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
