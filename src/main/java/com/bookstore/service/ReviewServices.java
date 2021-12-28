package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CustomerDao;
import com.bookstore.dao.ReviewDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewServices {
	private ReviewDao reviewDao;
	private BookDao bookDao;
	private CustomerDao customerDao;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public ReviewServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		
		reviewDao=new ReviewDao();
		customerDao=new CustomerDao();
		bookDao=new BookDao();
	}
	public void dispatcher(String path) throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}
	public void listAllReview() throws ServletException, IOException {
		listAllReview(null);
	}
	public void listAllReview(String message) throws ServletException, IOException {
		if (message!=null) {
			request.setAttribute("message", message);
		}
		List<Review>listReviews=reviewDao.listAll();
		request.setAttribute("listReview", listReviews);
		String path="review_list.jsp";
		dispatcher(path);
	}
	public void editReview() throws ServletException, IOException {
		Integer reviewId=Integer.parseInt(request.getParameter("id"));
		Review review=reviewDao.get(reviewId);
		request.setAttribute("review", review);
		String page="review_form.jsp";
		dispatcher(page);
		
	}
	public void updateReview() throws ServletException, IOException {
		Integer reviewId=Integer.parseInt(request.getParameter("reviewId"));
		String headline=request.getParameter("headline");
		String comment=request.getParameter("comment");
		Review review=reviewDao.get(reviewId);
		review.setComment(comment);
		review.setHeadline(headline);
		reviewDao.update(review);
		String message="update succseessfully";
		listAllReview(message);
		
		
	}
	public void deleteReview() throws ServletException, IOException {
		Integer reviewId=Integer.parseInt(request.getParameter("id"));
		reviewDao.delete(reviewId);
		String message="delete succseessfully";
		listAllReview(message);
		
	}
	public void showReviewForm() throws ServletException, IOException {
		Integer bookId=Integer.parseInt(request.getParameter("bookId"));
		Book book=bookDao.get(bookId);
		
		HttpSession session=request.getSession();
		session.setAttribute("book", book);
		
		Customer customer=(Customer) session.getAttribute("logged");
		
		Review review=reviewDao.findByCustomerAndBook(customer.getCustomerId(), bookId);
		String targetPage="frontend/review_form.jsp";
		if(review!=null) {
			request.setAttribute("review", review);
			targetPage="frontend/review_info.jsp";
			
		}
		dispatcher(targetPage);
		
		
		
	}
	
	public void submitReview() throws ServletException, IOException {
		Integer bookId=Integer.parseInt(request.getParameter("bookId"));
		float rating=Float.parseFloat(request.getParameter("rating"));
		String headline=request.getParameter("headline");
		String content=request.getParameter("content");
		
		Review review=new Review();
		review.setHeadline(headline);
		review.setComment(content);
		review.setRating((int) rating);
		
		Book book=bookDao.get(bookId);
		review.setBook(book);
		
		Customer customer=(Customer) request.getSession().getAttribute("logged");
		review.setCustomer(customer);
		reviewDao.create(review);
		
		String mes="frontend/review_done.jsp";
		dispatcher(mes);
		
		
	}
	
	
	

}
