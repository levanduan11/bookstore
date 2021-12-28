package com.bookstore.dao;

import com.bookstore.entity.Users;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao extends JpaDao<Users> implements GenericDao<Users> {
    public UserDao() {
       
    }

    @Override
    public Users create(Users users) {
        return super.create(users);
    }

    @Override
    public Users update(Users users) {
        return super.update(users);
    }

    @Override
    public Users get(Object id) {
        return super.find(Users.class, id);
    }

    public Users findByEmail(String email) {
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        List<Users> list = super.findWithNameQuery("Users.findByEmail",map);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    public boolean checkLogin(String email,String password) {
    	Map<String, String>map=new HashMap<String, String>();
    	map.put("email", email);
    	map.put("password", password);
    	List<Users>list=super.findWithNameQuery("Users.checkLogin", map);
    	
    	if(list.size()>0) {
    		return true;
    	}
    	
    	return false;
		
	}

    @Override
    public void delete(Object id) {
        super.delete(Users.class, id);
    }

    @Override
    public List<Users> listAll() {
        return super.findWithNameQuery("Users.findAll");
    }

    @Override
    public long count() {

        return super.countWithNamedQuery("Users.countAll");
    }
}
