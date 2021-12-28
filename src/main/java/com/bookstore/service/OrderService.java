package com.bookstore.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.controller.frontend.shoppingCart.ShoppingCart;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.OrderDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;

public class OrderService {
	private OrderDao orderDao;	
	private HttpServletRequest request;
	private HttpServletResponse response;
	public OrderService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		orderDao=new OrderDao();
	}
	public void listAllOrder() throws ServletException, IOException {
		listAllOrder(null);
	}
	public void dispatcher(String page) throws ServletException, IOException {
		request.getRequestDispatcher(page).forward(request, response);
		
	}
	public void listAllOrder(String message) throws ServletException, IOException {
		
		if (message!=null) {
			request.setAttribute("message", message);
		}
		List<BookOrder>listOrder=orderDao.listAll();
		request.setAttribute("listOrder", listOrder);
		String listPage="order_list.jsp";
		dispatcher(listPage);
		
	}
	public void viewOrderDetailForAdmin() throws ServletException, IOException {
		Integer orderId=Integer.parseInt(request.getParameter("id"));
		
		BookOrder bookOrder=orderDao.get(orderId);
		request.setAttribute("order", bookOrder);
		String listPage="order_detail.jsp";
		dispatcher(listPage);
	}
	
	public void showCheckOutForm() throws ServletException, IOException {
		
		String listPage="frontend/checkout.jsp";
		dispatcher(listPage);
	}
	
	public void placeOrder() throws ServletException, IOException {
		String recipientName=request.getParameter("recipientName");
		String recipientPhone=request.getParameter("recipientPhone");
		String address=request.getParameter("address");
		String country=request.getParameter("country");
		String city=request.getParameter("city");
		String zipcode=request.getParameter("zipcode");
		String payment=request.getParameter("payment");
		String shippingAdress=address+"-"+city+"-"+zipcode+"-"+country;
		
		BookOrder bookOrder=new BookOrder();
		bookOrder.setRecipientName(recipientName);
		bookOrder.setRecipientPhone(recipientPhone);
		bookOrder.setShippingAddress(shippingAdress);
		bookOrder.setPaymentMethod(payment);
		
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("logged");
		
		bookOrder.setCustomer(customer);
		
		ShoppingCart shoppingCart=(ShoppingCart) session.getAttribute("cart");
		Map<Book, Integer>map=shoppingCart.getItems();
		
		Iterator<Book>iterator=map.keySet().iterator();
		
		Set<OrderDetail>orderDetails=new HashSet<OrderDetail>();
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			Integer quantity=map.get(book);
			float subtotal=quantity*book.getPrice();
			
			OrderDetail oDetail=new OrderDetail();
			oDetail.setBook(book);
			oDetail.setBookOrder(bookOrder);
			oDetail.setQuantity(quantity);
			oDetail.setSubtotal(subtotal);
			
			orderDetails.add(oDetail);
		}
		
		bookOrder.setOrderDetails(orderDetails);
		bookOrder.setTotal( shoppingCart.getTotalAmount());
		
		orderDao.create(bookOrder);
		shoppingCart.clear();
		String message="thank you for order";
		request.setAttribute("message", message);
		String listPage="frontend/message.jsp";
		dispatcher(listPage);
	}
	
	public void listOrderByCustomer() throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		Customer customer=(Customer) session.getAttribute("logged");
		List<BookOrder>listOrders=orderDao.listByCustomer(customer.getCustomerId());
		
		request.setAttribute("listOrders", listOrders);
		String listPage="frontend/order_list.jsp";
		dispatcher(listPage);
		
	}
	
	public void showOderDetailForCustomer() throws ServletException, IOException {
	Integer orderId=Integer.parseInt(request.getParameter("id"));
		
	HttpSession session=request.getSession();
	Customer customer=(Customer) session.getAttribute("logged");
	
	
		BookOrder bookOrder=orderDao.get(orderId,customer.getCustomerId());
		request.setAttribute("order", bookOrder);
		String listPage="frontend/order_detail.jsp";
		dispatcher(listPage);
		
	}
	public void showEditOrderForm() throws ServletException, IOException {
		
		Integer orderId=Integer.parseInt(request.getParameter("id"));
		
		BookDao bookDao=new BookDao();
		HttpSession session=request.getSession();
		Object objectBook =session.getAttribute("newBook");
		if (objectBook==null) {
			BookOrder order=orderDao.get(orderId);
			session.setAttribute("order", order);
		}else {
			session.removeAttribute("newBook");
		}
		List<Book>listBooks=bookDao.listAll();
		session.setAttribute("listBooks", listBooks);
		
		
		String listPage="order_form.jsp";
		dispatcher(listPage);
	}
	
	public void updateOrder() throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		BookOrder order=(BookOrder) session.getAttribute("order");
		String recipientName=request.getParameter("recipientName");
		String recipientPhone=request.getParameter("recipientPhone");
		String shippingAddress=request.getParameter("shippingAddress");
		String paymentMethod=request.getParameter("paymentMethod");
		String status=request.getParameter("status");
		
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setPaymentMethod(paymentMethod);
		order.setShippingAddress(shippingAddress);
		order.setStatus(status);
		
		Integer []bookId=Arrays.stream(request.getParameterValues("bookIds"))
							.map(Integer::valueOf)
							.toArray(Integer[]::new);
		
		Float []price=Arrays.stream(request.getParameterValues("prices"))
							.map(Float::valueOf)
							.toArray(Float[]::new);
		Integer []quantities=new Integer[bookId.length];
		for (int i = 0; i < quantities.length; i++) {
			quantities[i]=Integer.parseInt(request.getParameter("quantity"+(i+1)));
			
		}
		Set<OrderDetail>orderDetails=order.getOrderDetails();
		orderDetails.clear();
		Float total=0.0f;
		for (int i = 0; i < bookId.length; i++) {
			Integer bId=bookId[i];
			Float pr=price[i];
			Integer q=quantities[i];
			
			Float subtotal=pr*q;
			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setBook(new Book(bId));
			orderDetail.setBookOrder(order);
			orderDetail.setQuantity(q);
			orderDetail.setSubtotal(subtotal);
			
			orderDetails.add(orderDetail);
			total+=subtotal;
		}
		order.setTotal(total);
		orderDao.update(order);
		
		String message="update sucessfully";
		listAllOrder(message);
		
	}
	
	public void deleteOrder() throws ServletException, IOException {
		Integer orderId=Integer.parseInt(request.getParameter("id"));
		orderDao.delete(orderId);
		String message="delete sucessfully";
		listAllOrder(message);
		
	}
	
	
}
