package com.bookstoretest.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Category;

public class ca {
	 public static void main(String[] args) {
	        Category users=new Category("java web");
	        

	      EntityManagerFactory emf= Persistence.createEntityManagerFactory("BookStoreWebsite");
	      EntityManager entityManager=emf.createEntityManager();
	      entityManager.getTransaction().begin();
	      entityManager.persist(users);
	      entityManager.getTransaction().commit();
	      entityManager.close();
	      emf.close();
	        System.out.println("done");
	    }
}
