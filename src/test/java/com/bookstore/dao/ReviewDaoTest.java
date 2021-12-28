package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Review;

public class ReviewDaoTest {
	private static ReviewDao reviewDao;
	private static CustomerDao customerDao;
	private static BookDao bookDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDao=new ReviewDao();
		customerDao=new CustomerDao();
		bookDao=new BookDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDao.close();
	}

	
	

	@Test
	public void testCreate() {
		Review review=new Review();
		review.setBook(bookDao.get(7));
		review.setCustomer(customerDao.get(3));
		review.setComment("very good");
		review.setHeadline("review headline");
		review.setRating(5);
		review=reviewDao.create(review);
		assertTrue(review!=null);
		
	}
	@Test
	public void testGet() {
		Review review=reviewDao.get(1);
		
		assertTrue(review!=null);
		
	}
	@Test
	public void testDelete() {
		
		reviewDao.delete(5);
		
		assertTrue(reviewDao.get(5)==null);
		
	}
	@Test
	public void testUpdate() {
		Review review=reviewDao.get(1);
		review.setComment("no good");
		reviewDao.update(review);
		
		assertTrue(review.getComment().equals("no good"));
		
	}
	@Test
	public void testListAll() {
		List<Review>list=reviewDao.listAll();
		
		assertTrue(list.size()>2);
		
	}
	@Test
	public void testfidByCustomerAndBook() {
		Review review= reviewDao.findByCustomerAndBook(3,7);
		System.out.println(review.getHeadline());
		assertTrue(review!=null);
		
	}
	@Test
	public void testlistRecentReviews() {
		List<Review>list=reviewDao.listRecentReviews();
		assertNotNull(list);
	}
	@Test
	public void testcountAll() {
		long c=reviewDao.count();
		
		assertTrue(c>0);
		
	}


}
