package com.bookstoretest.entity;
import com.bookstore.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UesrTest {
    public static void main(String[] args) {
        Users users=new Users();
        users.setEmail("java@gamil.com");
        users.setFullName("javaWeb");
        users.setPassword("123abc");
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
