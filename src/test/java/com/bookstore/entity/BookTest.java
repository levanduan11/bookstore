package com.bookstore.entity;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

	@Test
	public void testAveRating() {
		Book book=new Book();
		Set<Review>reviews=new HashSet<Review>();
		Review review=new Review();
		review.setRating(5);
		Review review1=new Review();
		review1.setRating(4);
		Review review2=new Review();
		review2.setRating(3);
		reviews.add(review);
		reviews.add(review1);
		reviews.add(review2);
		book.setReviews(reviews);
		float res=book.getAverageRating();
		
	}
	@Test
	public void testRating() {
		float ave=3.7f;
		Book book=new Book();
		String ranting=book.getRating(ave);
		String expected="off,off,off,off,off";
		System.out.println(ranting);
		assertEquals(ranting, expected);
	}

}
