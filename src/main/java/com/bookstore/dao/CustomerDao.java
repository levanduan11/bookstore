package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Customer;
import com.bookstore.entity.Users;

public class CustomerDao extends JpaDao<Customer> implements GenericDao<Customer> {

	
	@Override
	public Customer create(Customer customer) {
		customer.setRegisterDate(new Date());
		return super.create(customer);
	}

	@Override
	public Customer get(Object id) {
		
		return super.find(Customer.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Customer.class, id);
		
	}

	@Override
	public List<Customer> listAll() {
		
		return super.findWithNameQuery("Customer.findAll");
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("Customer.countAll");
	}
	
	public Customer findByEmail(String email) {
		 Map<String, String> map = new HashMap<>();
	        map.put("email", email);
	        List<Customer> list = super.findWithNameQuery("Customer.findByEmail",map);
	        if (list != null && list.size() > 0) {
	            return list.get(0);
	        }
	      
		return null;
	}
	public Customer checkLogin(String email,String password) {
		Map<String, String>map=new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		List<Customer>list=super.findWithNameQuery("Customer.checkLogin", map);
		if(!list.isEmpty()) {
			return list.get(0);
		}
		return null;
		
	}

}
