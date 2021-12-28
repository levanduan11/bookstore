package com.bookstore.controller.frontend.shoppingCart;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update_cart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[]bs=request.getParameterValues("bookId");
		String[]quantities=new String[bs.length];
		
		for (int i = 1; i <=bs.length ; i++) {
			quantities[i-1]=request.getParameter("quantity"+i);
			
		}
		System.out.println(Arrays.toString(quantities));
		Integer []bookIds=Arrays.stream(bs)
				.map(Integer::valueOf)
				.toArray(Integer[]::new);
		
		Integer []quantitie=Arrays.stream(quantities)
				.map(Integer::valueOf)
				.toArray(Integer[]::new);
		
		ShoppingCart cart=(ShoppingCart) request.getSession().getAttribute("cart");
		cart.updateCart(Arrays.asList(bookIds), Arrays.asList(quantitie));
		String redir=request.getContextPath().concat("/view_cart");
		response.sendRedirect(redir);
	}

}
