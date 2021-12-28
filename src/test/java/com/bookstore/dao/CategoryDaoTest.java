package com.bookstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

import java.util.List;

public class CategoryDaoTest {
	
	private static CategoryDao categoryDao;

	@BeforeClass
	public static void beforeClass() throws Exception {
		
		categoryDao = new CategoryDao();
	}

	@Test
	public void testCreate() {
		Category category=new Category("algorthms");
		category=categoryDao.create(category);
		assertTrue(category!=null&&category.getCategoryId()>0);
	}

	@Test
	public void testUpdate() {
		Category category=new Category("java core");
		category.setCategoryId(1);
		Category category2=categoryDao.update(category);
		assertEquals(category.getName(), category2.getName());
	}

	@Test
	public void testGet() {
		Integer id=2;
		Category category=categoryDao.get(id);
		assertNotNull(category);
	}

	@Test
	public void testDelete() {
		Integer id=23;
		categoryDao.delete(id);
		Category category=categoryDao.get(id);
		assertNull(category);
	}

	@Test
	public void testListAll() {
		List<Category>list=categoryDao.listAll();
		assertTrue(list.size()>0);
	}

	@Test
	public void coutAll() {
		long total=categoryDao.count();
		assertTrue(total>0);
	}

	@Test
	public void testFindByName() {
		String name="java";
		Category category=categoryDao.findByName(name);
		assertNotNull(category);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		categoryDao.close();
	}

}
