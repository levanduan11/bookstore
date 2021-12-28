package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Customer;
import com.bookstoretest.entity.ca;

public class CustomerDaoTest {
	private static CustomerDao customerDao;

	@BeforeClass
	public static void beforeClass() throws Exception {

		customerDao=new CustomerDao();
	}

	@Test
	public void testCreate() {
		Customer customer=new Customer();
		customer.setEmail("customer7@gmail.com");
		customer.setFullname("customer777");
		customer.setCity("quang binh");
		customer.setCountry("viet nam");
		customer.setAddress("badon-quang binh- viet nam");
		customer.setPassword("123a");
		customer.setPhone("0001111222");
		customer.setZipcode("100009");
		
		customer=customerDao.create(customer);
		assertTrue(customer.getCustomerId()>0);
		
	}
	@Test
	public void testGet() {
		Integer id=2;
		Customer customer=customerDao.get(id);
		System.out.println(customer.getFullname());
		assertTrue(customer!=null);
		
	}
	@Test
	public void testFindByEmail() {
		String email ="customer5@gmail.com";
		Customer customer=customerDao.findByEmail(email);
		
		assertTrue(customer!=null);
		
	}
	@Test
	public void testUpdate() {
		Integer id=3;
		Customer customer=customerDao.get(id);
		customer.setFullname("customer5");
		customer.setEmail("customer5@gmail.com");
		customer.setCity("tokyo");
		customerDao.update(customer);
		assertTrue(customer.getCity().equals("tokyo"));
		
	}
	@Test
	public void testDelete() {
		Integer id=11;
		customerDao.delete(id);
		Customer customer=customerDao.get(id);
		assertTrue(customer==null);
		
	}
	@Test
	public void testListAll() {
		List<Customer>list=customerDao.listAll();
		list.forEach(e->System.out.println(e.getFullname()));
		assertTrue(!list.isEmpty());
		
	}
	@Test
	public void testCount() {
		long count=customerDao.count();
		assertTrue(count>0);
		
	}
	@Test
	public void testLogin() {
		String email="banhhh@gmail.com";
		String password="123";
		Customer customer=customerDao.checkLogin(email, password);
		assertTrue(customer!=null);
		
	}




	@AfterClass
	public static void afterClass() throws Exception {
		customerDao.close();
	}

}
