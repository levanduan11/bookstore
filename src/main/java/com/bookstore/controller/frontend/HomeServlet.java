package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;


@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao categoryDao =new CategoryDao();
		BookDao bookDao=new BookDao();
		List<String>titles=Arrays.asList(
				"New Books","Best-Selling Books","Most-favored Books"
				);
		List<String>imgs=Arrays.asList(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRLZEZLSsLu2qxsiuEF-Y7P0mxIw3YhTXWfw&usqp=CAU",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcToioqPrk1W9WiexkqoqNYDf5-bvdaZxwAXDw&usqp=CAU",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThBPdNWJXnVxlnTiM3YcNafczf9qCKLWtSUg&usqp=CAU"
				
				);
		
		
		List<Book>listNewBooks=bookDao.listNewBooks();
		List<Book>listBestSellingBooks=bookDao.listBestSellingBooks();
		List<Book>listMostFavoredBooks=bookDao.listMostFavoredBooks();
		List<List<Book>>listAll=Arrays.asList(listNewBooks,listBestSellingBooks,listMostFavoredBooks);
		
		request.setAttribute("listAll", listAll);
		request.setAttribute("titles", titles);
		request.setAttribute("imgs", imgs);
		
		String page="frontend/index.jsp";
		request.getRequestDispatcher(page).forward(request,response);
	}

	

}
