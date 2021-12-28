package com.bookstore.service;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.Users;

public class UserService {
    private UserDao userDao;
   
    private HttpServletRequest request;
    private HttpServletResponse response;

    public UserService(HttpServletRequest request,HttpServletResponse response) {
     
        userDao = new UserDao();
        this.request=request;
        this.response=response;
        
    }
    public void listUser() throws ServletException, IOException {
       listUser(null);
    }

    public void listUser(String message) throws ServletException, IOException {
        List<Users> list = userDao.listAll();
        
		request.setAttribute("listUser", list);
		if(message!=null) {
			request.setAttribute("message",message);
		}
		
		 String listPage="user_list.jsp";
			request.getRequestDispatcher(listPage)
	                .forward(request,response);
    }
    public void createUser() throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String fullname=request.getParameter("fullname");
		Users existUser=userDao.findByEmail(email);
		if(existUser!=null){
            String message="could not create user .A user with email: "
                             +email+" already exist  ";
            request.setAttribute("errmessage",message);
            request.getRequestDispatcher("message.jsp")
                    .forward(request, response);
        }else {
            Users users=new Users(email,password,fullname);
            userDao.create(users);
            listUser("succsess fully");
        }

	}
	public void editUser() throws ServletException, IOException {
		Integer userid=Integer.parseInt(request.getParameter("id"));
		Users users=userDao.get(userid);
		
		String editPage="user_form.jsp";
		request.setAttribute("user", users);
		request.getRequestDispatcher(editPage)
		.forward(request, response);
		
		
	}
	public void updateUser() throws ServletException, IOException {
		Integer userId=Integer.parseInt(request.getParameter("userId"));
		String fullName=request.getParameter("fullname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Users u=userDao.findByEmail(email);
		Users uid=userDao.get(userId);
		String message="";
		if(u!=null&&!u.equals(uid)) {
			message="update fail email :"+email+" already exist";
			request.setAttribute("errmessage", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else {
			Users users=new Users(userId,email,password,fullName);
			userDao.update(users);
			message="update sucsses fully";
			listUser(message);
		}
		
				
		
	}
	public void deleteUser() throws ServletException, IOException {
		
		Integer userId=Integer.parseInt(request.getParameter("id"));
		Users users=userDao.get(userId);
		String message="";
		System.out.println(userId);
		if(users!=null) {
			message="delete sucsse fully";
			userDao.delete(userId);
			listUser(message);
		}else {
			message="delete fail id "+userId +" is not exist";
			request.setAttribute("errmessage", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
			
		}
		
		
	}
	public void loginUser() throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		boolean check=userDao.checkLogin(email, password);
		if(check) {
			System.out.println("check ok");
			request.getSession().setAttribute("useremail", email);
			request.getRequestDispatcher("/admin/").forward(request, response);
		}else {
			System.out.println("not ok");
			String messageyy="login failed";
			request.setAttribute("message", messageyy);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
	}
}
