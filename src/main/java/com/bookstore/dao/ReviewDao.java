package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Review;

public class ReviewDao extends JpaDao<Review> implements GenericDao<Review> {

	
	@Override
	public Review create(Review entity) {
		entity.setReviewTime(new Date());
		return super.create(entity);
	}

	@Override
	public Review get(Object id) {
	
		return super.find(Review.class, id);
	}
	

	@Override
	public Review update(Review entity) {
		
		return super.update(entity);
	}

	@Override
	public void delete(Object id) {
	super.delete(Review.class, id);
		
	}

	@Override
	public List<Review> listAll() {
		
		return super.findWithNameQuery("Review.listAll");
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("Review.countAll");
	}
	public Review findByCustomerAndBook(int customerId,int bookId) {
		Map<String,Integer>map=new HashMap<String, Integer>();
		map.put("customerId", customerId);
		map.put("bookId", bookId);
		List<Review>reviews=super.findWithNameQuery("Review.findByCustomerAndBook", map);
		if (!reviews.isEmpty()) {
			return reviews.get(0);
		}
		return null;
	}
public List<Review> listRecentReviews() {
		
		return super.findWithNameQuery("Review.listAll", 0, 3);
		
	}

}
