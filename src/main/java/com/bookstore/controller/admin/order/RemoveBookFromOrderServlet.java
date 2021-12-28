package com.bookstore.controller.admin.order;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.OrderDetail;

@WebServlet("/admin/remove_book_from_order")
public class RemoveBookFromOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer bookId=Integer.parseInt(request.getParameter("id"));
		HttpSession session=request.getSession();
		BookOrder bookOrder=(BookOrder) session.getAttribute("order");
		
		Set<OrderDetail>orderDetails=bookOrder.getOrderDetails();
		
		Iterator<OrderDetail>iterator=orderDetails.iterator();
		while (iterator.hasNext()) {
			OrderDetail orderDetail = (OrderDetail) iterator.next();
			
			if (orderDetail.getBook().getBookId()==bookId) {
				float newtotal=bookOrder.getTotal()-orderDetail.getSubtotal();
				bookOrder.setTotal(newtotal);
				iterator.remove();
			}
			
		}
		
		request.getRequestDispatcher("order_form.jsp").forward(request, response);
	}

}
