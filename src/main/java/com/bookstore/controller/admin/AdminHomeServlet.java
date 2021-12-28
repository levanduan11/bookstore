package com.bookstore.controller.admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CustomerDao;
import com.bookstore.dao.OrderDao;
import com.bookstore.dao.ReviewDao;
import com.bookstore.dao.UserDao;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

@WebServlet("/admin/")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminHomeServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String homepage = "index.jsp";
		OrderDao orderDao = new OrderDao();
		ReviewDao reviewDao = new ReviewDao();
		UserDao userDao=new UserDao();
		BookDao bookDao=new BookDao();
		CustomerDao customerDao=new CustomerDao();
		List<Long>totals=Arrays.asList(userDao.count(),bookDao.count(),customerDao.count(),reviewDao.count(),orderDao.count());
		request.setAttribute("totals", totals);
		List<String>names=Arrays.asList("Total user","Total book","Total customer","Total review","Total order");
		request.setAttribute("names", names);
		List<BookOrder> listRecentSales = orderDao.listRecentSales();

		request.setAttribute("listRecentSales", listRecentSales);

		List<Review> listRecentReviews = reviewDao.listRecentReviews();

		request.setAttribute("listRecentReviews", listRecentReviews);

		request.getRequestDispatcher(homepage).forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
