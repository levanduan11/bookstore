package com.bookstore.controller.frontend.shoppingCart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Book;


@WebServlet("/add_to_cart")
public class AddBookToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer bookId=Integer.parseInt(request.getParameter("bookId"));
		
		Object object=request.getSession().getAttribute("cart");
		
		ShoppingCart shoppingCart=null;
		if (object!=null&&object instanceof ShoppingCart) {
			shoppingCart=(ShoppingCart) object;
		}else {
			shoppingCart=new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
		}
		BookDao bookDao=new BookDao();
		Book book=bookDao.get(bookId);
		
		shoppingCart.add(book);
		String redir=request.getContextPath().concat("/view_cart");
		response.sendRedirect(redir);
	}

}
