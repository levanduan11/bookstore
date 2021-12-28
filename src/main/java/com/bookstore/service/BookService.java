package com.bookstore.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.Part;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookService {
	private BookDao bookDao;
	private CategoryDao categoryDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public BookService( HttpServletRequest request, HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
		bookDao = new BookDao();
		categoryDao = new CategoryDao();
	}

	public void listBooks() throws ServletException, IOException {
		listBooks(null);
	}

	public void listBooks(String message) throws ServletException, IOException {
		List<Book> lBooks = bookDao.listAll();
//		List<String>list=Arrays.asList(
//				"https://cdn.shopify.com/s/files/1/0059/8612/3866/collections/collections-model-iphone-6s-plus_medium.png?v=1627456246",
//				"https://cdn.shopify.com/s/files/1/0059/8612/3866/collections/collections-model-iphone-6s_medium.png?v=1627456248",
//				"https://cdn.shopify.com/s/files/1/0059/8612/3866/collections/iPhone-SE-2016_medium.png?v=1617860725",
//				"https://cdn.shopify.com/s/files/1/0059/8612/3866/collections/iPhone-SE-2016_medium.png?v=1617860725",
//				"https://cdn.shopify.com/s/files/1/0059/8612/3866/collections/iPhone-SE-2016_medium.png?v=1617860725"
//		);

		if (message != null) {
			request.setAttribute("message", message);
		}
		request.setAttribute("listBooks", lBooks);
		// request.setAttribute("listImg",list);
		String page = "book_list.jsp";
		request.getRequestDispatcher(page).forward(request, response);

	}

	public void showBookNewForm() throws ServletException, IOException {
		List<Category> list = categoryDao.listAll();
		request.setAttribute("listCategory", list);
		String page = "book_form.jsp";
		request.getRequestDispatcher(page).forward(request, response);

	}

	public void createBook() throws ParseException, ServletException, IOException {
		
		String title = request.getParameter("title");
		Book existBook = bookDao.findByTitle(title);
		String message = "";
		if (existBook != null) {
			message = "can not create book because " + title + " already";

			listBooks(message);
			return;
		}
		
		Book book = new Book();
		readBook(book);
		
		Book createBook = bookDao.create(book);
		if (createBook.getBookId() > 0) {
			message = "create successfully";
			
			listBooks(message);
		}

	}

	public void editBook() throws ServletException, IOException {
		Integer booId=Integer.parseInt(request.getParameter("id"));
		Book book=bookDao.get(booId);
		List<Category>list=categoryDao.listAll();
		request.setAttribute("listCategory", list);
		request.setAttribute("book", book);
		request.getRequestDispatcher("book_form.jsp").forward(request, response);
		
	}
public void readBook(Book book) {
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String isbn = request.getParameter("isbn");
	String description = request.getParameter("description");
	float price = Float.parseFloat(request.getParameter("price"));
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date publis=null;
	try {
		publis = dateFormat.parse(request.getParameter("publishDate"));
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	Integer categoryId = Integer.parseInt(request.getParameter("category"));
	Category category = categoryDao.get(categoryId);
	
	book.setTitle(title);
	book.setAuthor(author);
	book.setDescription(description);
	book.setIsbn(isbn);
	book.setPublishDate(publis);
	book.setCategory(category);
	book.setPrice(price);

	
}
	public void updateBook() throws ServletException, IOException {
		Integer booId=Integer.parseInt(request.getParameter("bookId"));
		String title=request.getParameter("title");
		Book bookTitle=bookDao.findByTitle(title);
		Book book=bookDao.get(booId);
		String message="";
		if(bookTitle!=null&&!book.equals(bookTitle)) {
			message="can not update book "+title+" already";
			listBooks(message);
			return;
		}
		
		readBook(book);
		bookDao.update(book);
		 message="update success fully";
		listBooks(message);
		
		
		
	}

	public void deleteBook() throws ServletException, IOException {
		Integer booId=Integer.parseInt(request.getParameter("id"));
		bookDao.delete(booId);
		String message="the book deleted succsess fully";
		listBooks(message);
		
	}

	public void listBookByCategory() throws ServletException, IOException {
		
		
		int categoryId=Integer.parseInt(request.getParameter("id"));
		Category category=categoryDao.get(categoryId);
		List<Book>list=bookDao.listByCategory(categoryId);
		
		request.setAttribute("category", category);
		
		request.setAttribute("listBooks", list);
		
		String page="frontend/book_list_by_category.jsp";
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}

	public void viewBookDetail() throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		Book book=bookDao.get(id);
		
		
		request.setAttribute("book", book);
		
		
		String page="frontend/book_detail.jsp";
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}

	public void search() throws ServletException, IOException {
		String keyword=request.getParameter("keyword");
		List<Category>listCategory=categoryDao.listAll();
		List<Book>list=null;
		if (keyword.equals("")) {
			list=bookDao.listAll();
		}else {
			list=bookDao.search(keyword);
		}
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("keyword", keyword);
		request.setAttribute("search", list);
		String page="frontend/search_result.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

}
