package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;

public class OrderDao extends JpaDao<BookOrder> implements GenericDao<BookOrder> {

	
	
	
	
	
	@Override
	public BookOrder create(BookOrder entity) {
		entity.setOrderDate(new Date());
		
		entity.setStatus("Processing");
		return super.create(entity);
	}

	@Override
	public BookOrder update(BookOrder entity) {
		
		return super.update(entity);
	}

	

	@Override
	public BookOrder get(Object id) {
		
		return find(BookOrder.class, id);
	}
	
	public BookOrder get(Integer orId,Integer customerId) {
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("orderId", orId);
		map.put("customerId", customerId);
		List<BookOrder>result=findWithNameQuery("BookOrder.findByIdAndCustomer",map);
		return result.isEmpty()? null:result.get(0);
	}

	@Override
	public void delete(Object id) {
	
		super.delete(BookOrder.class, id);
	}

	@Override
	public List<BookOrder> listAll() {
		
		return super.findWithNameQuery("BookOrder.findAll");
	}

	public List<BookOrder> listByCustomer(Integer customerId) {
		
		return super.findWithNameQuery("BookOrder.findByCustomer","customerId",customerId);
	}
	public List<BookOrder> listRecentSales() {
		
		return super.findWithNameQuery("BookOrder.findAll", 0, 3);
		
	}
	@Override
	public long count() {
		
		return super.countWithNamedQuery("BookOrder.countAll");
	}
	

}
