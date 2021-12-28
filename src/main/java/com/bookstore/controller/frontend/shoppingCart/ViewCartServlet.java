package com.bookstore.controller.frontend.shoppingCart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;


@WebServlet("/view_cart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object cartObject=request.getSession().getAttribute("cart");
		if (cartObject==null) {
			ShoppingCart shoppingCart=new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
			
		}
		
		String cartPage="frontend/shopping_cart.jsp";
		request.getRequestDispatcher(cartPage).forward(request, response);
	}

}
