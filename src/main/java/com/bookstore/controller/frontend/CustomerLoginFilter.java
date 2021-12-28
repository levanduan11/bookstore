package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;


@WebFilter("/*")
public class CustomerLoginFilter implements Filter {
	private static final List<String>required=Arrays.asList(
			"/view_profile","/edit_profile","/update_profile"
			,"/write_review","/checkout","/place_order","/view_orders","/show_order_detail"
			
			);
 
	public void destroy() {
		
	}

	private boolean loginRequired(String require) {
		
		return required.stream().anyMatch(e->require.contains(e));
				
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hRequest=(HttpServletRequest) request;
		HttpSession session= hRequest.getSession(false);
		
		String path=hRequest.getRequestURI().substring(hRequest.getContextPath().length());
		System.out.println("uri llll"+hRequest.getRequestURI());
		System.out.println("context paht"+hRequest.getContextPath());
		if (path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
		}
		System.out.println("paht:::"+path);
		boolean longgedIn=session!=null&&session.getAttribute("logged")!=null;
		System.out.println(longgedIn);
		String reUrl=hRequest.getRequestURI();
		if (!longgedIn&&loginRequired(reUrl)) {
			String query=hRequest.getQueryString();
			if (query!=null) {
				reUrl=reUrl.concat("?").concat(query);
			}
			session.setAttribute("reUrl", reUrl);
			String logginPage="frontend/login.jsp";
			request.getRequestDispatcher(logginPage).forward(hRequest, response);
		}else {
			chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
