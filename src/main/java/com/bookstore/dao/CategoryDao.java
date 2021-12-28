package com.bookstore.dao;

import com.bookstore.entity.Category;

import javax.persistence.EntityManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDao extends JpaDao<Category> implements GenericDao<Category> {

	
    public CategoryDao() {
      
    }

    @Override
    public Category get(Object id) {
        return super.find(Category.class,id);
    }

    @Override
    public void delete(Object id) {
       super.delete(Category.class,id);
    }

    @Override
    public List<Category> listAll() {
        return super.findWithNameQuery("Category.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Category.countAll");
    }

	@Override
	public Category create(Category entity) {
		return super.create(entity);
	}

	@Override
	public Category update(Category entity) {
		return super.update(entity);
	}
	public Category findByName(String categoryName) {
		Map<String, String>map=new HashMap<String, String>();
		map.put("name", categoryName);
		List<Category>list=super.findWithNameQuery("Category.findByName", map);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
    
}
