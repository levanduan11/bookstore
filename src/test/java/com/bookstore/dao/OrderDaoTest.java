package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;
import com.bookstore.entity.OrderDetailId;

public class OrderDaoTest {

	private static OrderDao orderDao;
	private static CustomerDao customerdao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		orderDao = new OrderDao();
		customerdao = new CustomerDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		orderDao.close();
	}

	@Test
	public void testCreateBookOrder() {
		BookOrder bookOrder = new BookOrder();
		Customer customer = customerdao.get(15);

		bookOrder.setCustomer(customer);
		bookOrder.setShippingAddress("badon-quang binh-viet nam");
		bookOrder.setRecipientName("nguyen van an");
		bookOrder.setRecipientPhone("00-99-77799");
		bookOrder.setTotal(9);

		Set<OrderDetail> set = new HashSet<OrderDetail>();
		OrderDetail orderDetail = new OrderDetail();

		Book book = new Book(11);
		orderDetail.setBook(book);
		orderDetail.setQuantity(2);
		orderDetail.setSubtotal(170.7f);
		orderDetail.setBookOrder(bookOrder);

		set.add(orderDetail);
		bookOrder.setOrderDetails(set);

		BookOrder bookOrder2 = orderDao.create(bookOrder);
		assertNotNull(bookOrder2);

	}

	@Test
	public void testUpdateBookOrderShippingAddress() {

		BookOrder bookOrder = orderDao.get(7);
		bookOrder.setShippingAddress("new address");
		orderDao.update(bookOrder);
		assertEquals(bookOrder.getShippingAddress(), "new address");
	}

	@Test
	public void testUpdateBookOrderDetail() {

		BookOrder bookOrder = orderDao.get(7);

		Iterator<OrderDetail> oIterator = bookOrder.getOrderDetails().iterator();
		while (oIterator.hasNext()) {
			OrderDetail orderDetail = (OrderDetail) oIterator.next();
			if (orderDetail.getBook().getBookId()==11) {
				orderDetail.setQuantity(13);
				orderDetail.setSubtotal(120);;
				
			}
		}
		oIterator = bookOrder.getOrderDetails().iterator();
		int a=0;
		float b=0;
		while (oIterator.hasNext()) {
			OrderDetail orderDetail = (OrderDetail) oIterator.next();
			if (orderDetail.getBook().getBookId()==11) {
				a=orderDetail.getQuantity();
				b=orderDetail.getSubtotal();
				
			}
		}
		
		orderDao.update(bookOrder);
		assertEquals(a, 13);
		assertEquals(b, 120,0);
	}

	@Test
	public void testGet() {
		BookOrder bookOrder = orderDao.get(6);
		System.out.println(bookOrder.getTotal());
		assertNotNull(bookOrder);
	}
	@Test
	public void testlistRecentSales() {
		List<BookOrder>list=orderDao.listRecentSales();
		assertNotNull(list);
	}
	@Test
	public void testListByCustomer() {
		List<BookOrder>list=orderDao.listByCustomer(15);
	list.forEach(e->System.out.println(e.getCustomer().getFullname()));
		assertNotNull(list);
	}

	@Test
	public void testDeleteObject() {
		
		orderDao.delete(8);
		BookOrder bookOrder=orderDao.get(8);
		assertNull(bookOrder);
	}

	@Test
	public void testListAll() {
		List<BookOrder> list = orderDao.listAll();
		list.forEach(e -> System.out.println(e.getOrderDate()));
		assertNotNull(list);
	}
	@Test
	public void testGetByIdAndCustomer() {
		BookOrder bookOrder=orderDao.get(7, 8);
		System.out.println(bookOrder.getShippingAddress());
		assertNotNull(bookOrder);
	}
	@Test
	public void testCount() {
		long total=orderDao.count();
		assertEquals(2, total);
	}

}
