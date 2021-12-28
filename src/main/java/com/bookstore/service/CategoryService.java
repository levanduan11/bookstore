package com.bookstore.service;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.UserDao;
import com.bookstore.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class CategoryService {
	private CategoryDao categoryDao;
	
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CategoryService( HttpServletRequest request, HttpServletResponse response) {
	
		categoryDao = new CategoryDao();

		this.request = request;
		this.response = response;

	}
	public void listCategory() throws ServletException, IOException {
		listCategory(null);

	}

	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listCategory = categoryDao.listAll();
		if(message!=null) {
			request.setAttribute("message", message);
		}
		request.setAttribute("listCategory", listCategory);
		String listPage = "category_list.jsp";
		request.getRequestDispatcher(listPage).forward(request, response);

	}
	public void createCategory() throws ServletException, IOException {
		String name=request.getParameter("name");
		Category category=categoryDao.findByName(name);
		String message="";
		if(category!=null){
			message="could not create category ";
			request.setAttribute("errmessage",message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else {
			message="create Category succsess fully";
			Category category1=new Category(name);
			categoryDao.create(category1);
			listCategory(message);
			

		}
		
	}
	public void editCategory() throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		Category category=categoryDao.get(id);
		request.setAttribute("category", category);
		
		String editPage="category_form.jsp";
		request.getRequestDispatcher(editPage)
		.forward(request, response);
		
	}
	public void updateCategory() throws ServletException, IOException {
		Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
		String name=request.getParameter("name");
		
		String message="";
		Category category2=categoryDao.findByName(name);
		if(category2!=null&&categoryId!=category2.getCategoryId()) {
			message="can not update";
			request.setAttribute("errmessage", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
			
		}else {
			Category category3=new Category(categoryId,name);
			message="update succsee fully";
			categoryDao.update(category3);
			listCategory(message);
			
		}
		
	}
	public void deleteCategory() throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		BookDao bookDao=new BookDao();
		int books=(int) bookDao.countBycategory(id);
		String message="";
		if(books > 0) {
			message="could not delete the category (Id:%d) because contains some books";
			message=String.format(message, id);
			
			
		}else {
			Category category=categoryDao.get(id);
			
			
			if(category!=null) {
				message="delete succsse fully";
				categoryDao.delete(id);
				
			}else {
				message="delete fail ";
				request.setAttribute("errmessage", message);
				request.getRequestDispatcher("message.jsp").forward(request, response);
				
			}
			
		}
		listCategory(message);
		
		
	}
}
