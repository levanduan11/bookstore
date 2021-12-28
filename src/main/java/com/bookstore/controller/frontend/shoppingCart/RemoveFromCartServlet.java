package com.bookstore.controller.frontend.shoppingCart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Book;


@WebServlet("/remove_from_cart")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer bookId=Integer.parseInt(request.getParameter("book_id"));
		
		Object object=request.getSession().getAttribute("cart");
		
		ShoppingCart shoppingCart=(ShoppingCart) object;
	
		shoppingCart.remove(new Book(bookId));
		
		
		String redir=request.getContextPath().concat("/view_cart");
		response.sendRedirect(redir);
	}

}
