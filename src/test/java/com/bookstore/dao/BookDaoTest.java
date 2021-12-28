package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

import javax.persistence.EntityNotFoundException;

public class BookDaoTest  {
    private static BookDao bookDao;
    private static CategoryDao categoryDao;

    @BeforeClass
    public static void beforeClass() throws Exception {
        
        bookDao = new BookDao();
        categoryDao=new CategoryDao();
    }

    @Test
    public void testCreateBook() throws ParseException, IOException {
        Book book = new Book();
        Category category = categoryDao.get(2);
        book.setCategory(category);
        book.setTitle("java 8 in action 1 ");
        book.setAuthor("author 3");
        book.setDescription("java tutorial 3");
        book.setPrice(10.2f);
        book.setIsbn("00002");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = dateFormat.parse("1/3/2000");
        book.setPublishDate(date);
        String img = "C:\\Users\\user\\OneDrive\\Tài liệu\\7.jpg";
        byte[] im1 = Files.readAllBytes(Paths.get(img));
	    book.setImage(im1);
        Book book2 = bookDao.create(book);
        assertTrue(book2.getBookId() > 0);

    }

    @Test
    public void testUpdateBook() throws ParseException, IOException {
        Book book = new Book();
        book.setBookId(1);
        Category category = new Category("javaApp");
        category.setCategoryId(1);
        book.setCategory(category);
        book.setTitle("java programming effective 0");
        book.setAuthor("author 1");
        book.setDescription("java tutorial 1");
        book.setPrice(10.1f);
        book.setIsbn("00000");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = dateFormat.parse("1/2/2000");
        book.setPublishDate(date);
        String img = "C:\\Users\\user\\OneDrive\\Hình ảnh\\projectS\\img\\7.png";
        byte[] im1 = Files.readAllBytes(Paths.get(img));
        book.setImage(im1);
        Book book2 = bookDao.update(book);
        assertEquals(book2.getTitle(),"java programming effective 0");
        Book bookg= bookDao.get(2);
        book.setTitle("java programming effective 1");
        bookDao.update(bookg);
        assertEquals(book.getTitle(),"java programming effective 1");
    }
    @Test
    public void testDeleteBook() {
        Integer bookId=1;
        bookDao.delete(bookId);
        assertTrue(true);
    }
    @Test(expected = EntityNotFoundException.class)
    public void testDeleteBookFail() {
        Integer bookId=100;
        bookDao.delete(bookId);
       assertTrue(true);
    }
    @Test
    public void testGetBook() {
        Integer bookId=2;
        Book book= bookDao.get(bookId);
        System.out.println(book.getAuthor());
        assertNotNull(book);
    }

    @Test
    public void testGetBookFail() {
      Integer bookId=100;
      Book book= bookDao.get(bookId);
      assertNull(book);
    }

    @Test
    public void testListAll() {
        List<Book>list=bookDao.listAll();
        list.forEach(e-> System.out.println(e.getAuthor()));
        assertFalse(list.isEmpty());
    }
    @Test
    public void testFindByTitle() {
        String title="java 8 in action ";
        Book book=bookDao.findByTitle(title);
        System.out.println(book.getTitle());
        assertNotNull(book);
    }
    @Test
    public void testFindByTitleFail() {
        String title="fdfd";
        Book book=bookDao.findByTitle(title);
        assertNull(book);
    }

    @Test
    public void testCount() {
        long total=bookDao.count();
        assertEquals(2,total);
    }

    @Test
    public void listByCategory() {
        int categoryId=1;
        List<Book>list=bookDao.listByCategory(categoryId);
        list.forEach(e-> System.out.println(e.getTitle()));
        assertTrue(!list.isEmpty());
    }

    @Test
    public void listNewBook1() {
        List<Book>list=bookDao.listNewBooks();
        list.forEach(e-> System.out.println(e.getPublishDate()));
        assertTrue(!list.isEmpty());
    }

    @Test
    public void testSearchBookTitle() {
        String keyword="caps";
        List<Book>list=bookDao.search(keyword);
        list.forEach(e-> System.out.println(e.getDescription()));
        assertTrue(!list.isEmpty());
    }
    @Test
    public void testCountByCategory() {
    	int categoryId=1;
    	long books=bookDao.countBycategory(categoryId);
    	System.out.println(books);
    	assertTrue(books>0);
    }
    @Test
    public void listBestSellingBooks() {
    	List<Book>list=bookDao.listBestSellingBooks();
    	
    	assertTrue(!list.isEmpty());
    }
   
    @Test
    public void listMostFavoredBooks() {
    	List<Book>list=bookDao.listMostFavoredBooks();
    	list.forEach(i->System.out.println(i.getBookId()));
    	assertTrue(!list.isEmpty());
    }

    @AfterClass
    public static void afterClass() throws Exception {
       bookDao.close();
    }


}
