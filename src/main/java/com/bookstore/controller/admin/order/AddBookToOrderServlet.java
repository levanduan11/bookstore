package com.bookstore.controller.admin.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.OrderDetail;
import com.bookstore.service.OrderService;


@WebServlet("/admin/add_book_to_order")
public class AddBookToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		
		Integer bookId=Integer.parseInt(request.getParameter("bookId"));
		Integer quantity=Integer.parseInt(request.getParameter("quantity"));
		
		BookDao bookDao=new BookDao();
		Book book=bookDao.get(bookId);
		
		HttpSession session=request.getSession();
		BookOrder order=(BookOrder) session.getAttribute("order");
		
		float subtotal=quantity*book.getPrice();
		
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setBook(book);
		orderDetail.setQuantity(quantity);
		orderDetail.setSubtotal(subtotal);
		
		float total=order.getTotal()+subtotal;
		order.setTotal(total);
		
		order.getOrderDetails().add(orderDetail);
		
		session.setAttribute("book", book);
		session.setAttribute("newBook", true);
		
		request.getRequestDispatcher("order_form.jsp").forward(request, response);
		
	}

}
