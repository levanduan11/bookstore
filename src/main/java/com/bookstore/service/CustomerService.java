package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.CustomerDao;
import com.bookstore.entity.Customer;

public class CustomerService {

	private CustomerDao customerDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CustomerService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		customerDao = new CustomerDao();
	}

	public void listCustomer() throws ServletException, IOException {

		listCustomer(null);
	}

	public void listCustomer(String message) throws ServletException, IOException {

		List<Customer> listCustomers = customerDao.listAll();
		if (message != null) {
			request.setAttribute("message", message);

		}
		request.setAttribute("listCustomer", listCustomers);
		String page = "customer_list.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

	public void createCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer emailc = customerDao.findByEmail(email);
		String message = "";
		if (emailc != null) {
			message = "could not create customer the email " + email + "already exist";
			listCustomer(message);

		} else {

			Customer customer = new Customer();
			updateFilCustomer(customer);

			customerDao.create(customer);
			message = "create succsee fully";
			listCustomer(message);
		}

	}

	public void editCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDao.get(customerId);
		request.setAttribute("customer", customer);
		String page = "customer_form.jsp";
		request.getRequestDispatcher(page).forward(request, response);

	}

	public void updateCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("customerId"));

		String email = request.getParameter("email");
		Customer customerid = customerDao.get(customerId);
		Customer cemail = customerDao.findByEmail(email);
		String message = "";
		if (cemail != null && !cemail.equals(customerid)) {
			message = "could not update the customerId " + customerId + "because aready email " + email;

		} else {
			updateFilCustomer(customerid);
			customerDao.update(customerid);
			message = "update succsee fully";

		}
		listCustomer(message);

	}

	public void updateFilCustomer(Customer customer) {
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");

		if (email != null && !email.equals("")) {
			customer.setEmail(email);
		}
		if (password != null && !password.equals("")) {
			customer.setPassword(password);
		}

		customer.setFullname(fullname);

		customer.setPhone(phone);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setZipcode(zipcode);
		customer.setCountry(country);

	}

	public void deleteCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		customerDao.delete(customerId);
		String mesesage = "";
		mesesage = "delete sucessfully";
		listCustomer(mesesage);

	}

	public void registerCustomer() throws ServletException, IOException {

		String email = request.getParameter("email");
		Customer emailc = customerDao.findByEmail(email);
		String message = "";
		if (emailc != null) {
			message = "could not create registere the email " + email + "already exist";

		} else {

			Customer customer = new Customer();
			updateFilCustomer(customer);
			customerDao.create(customer);

			message = "Register succseefully <a href='login'>click here to login</a>";

		}
		String page = "/frontend/message.jsp";
		request.setAttribute("message", message);
		request.getRequestDispatcher(page).forward(request, response);
	}

	public void showLogin() throws ServletException, IOException {
		String loginPage = "frontend/login.jsp";
		request.getRequestDispatcher(loginPage).forward(request, response);

	}

	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Customer customer = customerDao.checkLogin(email, password);
		String message = null;
		if (customer == null) {
			message = "login please check your email and password";
			request.setAttribute("message", message);
			showLogin();
		} else {
			HttpSession session=request.getSession();
			session.setAttribute("logged", customer);
			Object object=session.getAttribute("reUrl");
			if(object!=null) {
				String redi=(String) object;
				session.removeAttribute("reUrl");
				response.sendRedirect(redi);
				
			}else {
				showCustomerProfile();
			}
			
			
		}

	}

	public void showCustomerProfile() throws ServletException, IOException {
		String profilePage = "frontend/customer_profile.jsp";
		request.getRequestDispatcher(profilePage).forward(request, response);
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {

		String profilePage = "frontend/edit_profile.jsp";
		request.getRequestDispatcher(profilePage).forward(request, response);
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("logged");
		updateFilCustomer(customer);
		customerDao.update(customer);
		showCustomerProfile();

	}

}
