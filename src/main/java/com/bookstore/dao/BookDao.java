package com.bookstore.dao;

import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookstore.entity.Book;

public class BookDao extends JpaDao<Book> implements GenericDao<Book> {

	public BookDao() {

	}

	@Override
	public Book create(Book entity) {
		entity.setLastUpdateTime(new Date());
		return super.create(entity);
	}

	@Override
	public Book update(Book entity) {
		entity.setLastUpdateTime(new Date());
		return super.update(entity);
	}

	@Override
	public Book get(Object id) {

		return super.find(Book.class, id);
	}

	@Override
	public void delete(Object id) {

		super.delete(Book.class, id);
	}

	@Override
	public List<Book> listAll() {

		return super.findWithNameQuery("Book.findAll");
	}

	public Book findByTitle(String title) {
		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		List<Book> res = super.findWithNameQuery("Book.findByTitle", map);
		if (!res.isEmpty()) {
			return res.get(0);
		}
		return null;
	}

	public List<Book> listByCategory(int categoryId) {

		return findWithNameQuery("Book.findByCategory", "caId", categoryId);
	}

	public List<Book> listNewBooks1() {
		if (listAll().size() == 0)
			return null;
		if (listAll().size() < 4)
			return listAll();
		List<Book> res = listAll().stream().sorted((b1, b2) -> b2.getPublishDate().compareTo(b1.getPublishDate()))
				.limit(4).collect(Collectors.toList());
		return res;

	}

	public List<Book> listNewBooks() {

		return super.findWithNameQuery("Book.listNew", 0, 4);
	}

	public List<Book> search(String keyword) {
		return super.findWithNameQuery("Book.search", "keyword", keyword);

	}

	@Override
	public long count() {

		return super.countWithNamedQuery("Book.countAll");
	}

	public long countBycategory(int category) {

		return super.countWithNamedQuery("Book.countByCategory", "cId", category);
	}

	public List<Book> listBestSellingBooks() {
		return super.findWithNameQuery("OrderDetail.bestSelling", 0, 4);

	}
	public List<Book>  listMostFavoredBooks() {
		return super.findWithNameQuery("Review.mostFavoredBooks", 0, 4);

	}

}
