package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Category;


@WebFilter("/*")
public class CommonFilter implements Filter {
	
	private final CategoryDao categoryDao;

	public  CommonFilter() {
		categoryDao=new CategoryDao();
	}
	public void destroy() {
	
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hRequest=(HttpServletRequest) request;
		String path=hRequest.getRequestURI().substring(hRequest.getContextPath().length());
		System.out.println("filter->"+path);
		if (!path.startsWith("/admin/")) {
			List<Category>listCategory=categoryDao.listAll();
			request.setAttribute("listCategory", listCategory);
			
			System.out.println("common filter");
			
		}
		chain.doFilter(request, response);
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
