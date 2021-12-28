package com.bookstore.controller.frontend.shoppingCart;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Book;



public class ShoppingCartTest {
	private static ShoppingCart cart;


	  @BeforeClass
	    public static void beforeClass() throws Exception {
	        
		  cart = new ShoppingCart();
			Book book = new Book(1);
			book.setPrice(10);
			cart.add(book);
			cart.add(book);
	    }


	@Test
	public void testAdd() {

		Book book = new Book(1);

		cart.add(book);
		cart.add(book);
		Map<Book, Integer> iMap = cart.getItems();
		int quantity = iMap.get(book);
		assertEquals(2, quantity);
	}

	@Test
	public void testRemove() {

		Book book=new Book(1);
		cart.remove(new Book(1));
		Map<Book, Integer>iMap=cart.getItems();
		
		assertTrue(iMap.get(book)==null);
	}

	@Test
	public void testGetTotal() {

		Book book = new Book(3);

		cart.add(book);
		cart.add(book);
		System.out.println(cart.getTotalQuantity());
		assertTrue(4 == cart.getTotalQuantity());
	}

	@Test
	public void testGetTotalAmount() {
		ShoppingCart cart = new ShoppingCart();
		assertEquals(0, cart.getTotalAmount(), 0);
	}
	@Test
	public void testGetTotalAmount1() {
		
		assertEquals(20, cart.getTotalAmount(), 0);
	}

	@Test
	public void testcl() {
		cart.clear();
		assertEquals(0, cart.getTotalAmount(),0);
	}
	@Test
	public void testUpate() {
		ShoppingCart cart = new ShoppingCart();
		Book book=new Book(1);
		Book book1=new Book(2);
		cart.add(book);
		cart.add(book1);
		List<Integer>bookIds=Arrays.asList(1,2);
		List<Integer>quantities=Arrays.asList(3,4);
		cart.updateCart(bookIds, quantities);
		assertEquals(7, cart.getTotalQuantity());
		
				
	}
}
