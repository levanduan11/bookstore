package com.bookstore.controller.frontend.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.CustomerService;


@WebServlet("/update_profile")
public class UpdateCustomerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerService customerService=new CustomerService(req, resp);
		customerService.updateCustomerProfile();
	}

	
}
