package com.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class JpaDao<E> {
	private static EntityManagerFactory entityManagerFactory;
	

    static {
    	entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		
    }
    public JpaDao() {
      
    }

    public E create(E entity) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    public E update(E entity) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    public E find(Class<E> type, Object id) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
        E entity = entityManager.find(type, id);
        if (entity != null) {
            entityManager.refresh(entity);
        }
        entityManager.close();
        return entity;
    }

    public void delete(Class<E> type, Object id) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Object reference = entityManager.getReference(type, id);
        entityManager.remove(reference);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<E> findWithNameQuery(String name) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(name);
        
        List<E>result=query.getResultList();
        entityManager.close();
        return result;
    }
    public List<E> findWithNameQuery(String name,int firstResult,int maxResult) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(name);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        
        List<E>result=query.getResultList();
        entityManager.close();
        return result;
    }

    public List<E> findWithNameQuery(String name, String pram, Object value) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(name);
        query.setParameter(pram, value);
        List<E>result=query.getResultList();
        entityManager.close();
        return result;
    }
    public<V> List<E> findWithNameQuery(String name, Map<String, V>p) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(name);
        for(Map.Entry m:p.entrySet()){
            String k= (String) m.getKey();
            V v= (V) m.getValue();
            query.setParameter(k,v);
        }
        List<E>result=query.getResultList();
        entityManager.close();
        return result;
    }

    public long countWithNamedQuery(String name) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(name);
        long result=(long) query.getSingleResult();
        entityManager.close();
        return result;
    }
    public long countWithNamedQuery(String name,String param,Object value) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(name);
        query.setParameter(param, value);
        
        long result=(long) query.getSingleResult();
        entityManager.close();
        return result;
    }
    
    
    public void close() {
    	if(entityManagerFactory!=null) {
    		entityManagerFactory.close();
    	}
		
	}
}
