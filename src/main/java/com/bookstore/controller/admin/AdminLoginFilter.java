package com.bookstore.controller.admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    
    public AdminLoginFilter() {
       
    }

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		HttpSession session=httpServletRequest.getSession(false);//nhan dc mot phien va ko tao phien moi neu phien ko ton tai
		//cau lenh nay nhan mot phien neu no ton tai
		//neu ko thi phien rong
		
		String url=httpServletRequest.getContextPath()+"/admin/login";
		boolean loginRequest=httpServletRequest.getRequestURI().equals(url);
		boolean loggedIn=session!=null&&session.getAttribute("useremail")!=null;
		boolean loginPage=httpServletRequest.getRequestURI().endsWith("login.jsp");
		if(loggedIn&&(loginPage||loginRequest)) {
			request.getRequestDispatcher("/admin/").forward(httpServletRequest, response);
			
		}
		else if(loggedIn||loginRequest) {
			System.out.println("login");
			chain.doFilter(request, response);
		}
		else {
			System.out.println("no login");
			request.getRequestDispatcher("login.jsp").forward(httpServletRequest, response);
			
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
