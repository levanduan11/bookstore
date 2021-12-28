package com.bookstore.controller.admin.book;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.bookstore.service.BookService;


@WebServlet("/admin/create_book")
@MultipartConfig(
		fileSizeThreshold = 1024*10,//10kb
		maxFileSize =1024*300,//300kb
		maxRequestSize = 1024*1024 //1mp
)
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService=new BookService( request, response);
		try {
			bookService.createBook();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

	}

}
