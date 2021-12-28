package com.bookstore.dao;

import static org.junit.Assert.*;

import com.bookstore.entity.Users;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class UserDaoTest  {
  
    private static UserDao userDao;

    @BeforeClass
    public static void beforeClass() throws Exception {
       
        userDao = new UserDao();
    }

    @Test
    public void testCreateUsers() {
        Users users = new Users();
        users.setEmail("tuan@gmail.com");
        users.setFullName("tuan");
        users.setPassword("123a");
        users = userDao.create(users);
        assertTrue(users.getUserId() > 0);
    }

    @Test(expected = PersistenceException.class)
    public void testCreateFieldsNotSet() {
        Users users = new Users();
        userDao.create(users);
    }

    @Test
    public void testUpdate() {
        Users users=new Users();
        users.setUserId(1);
        users.setEmail("k@gmail.com");
        users.setPassword("1237");
        users.setFullName("nam");
        users=userDao.update(users);
        String p="1237";
        String pp=users.getPassword();
        assertEquals(p,pp);
    }

    @Test
    public void testGetUserFound() {
        Integer userId=1;
       Users users= userDao.get(userId);
        assertNotNull(users);
    }


    @Test
    public void testGetUserNotFound() {
        Integer userId=19;
        Users users= userDao.get(userId);
        assertNull(users);
    }

    @Test
    public void testDeleteUsers() {
        Integer userId=6;
        userDao.delete(userId);
        Users users=userDao.get(userId);
        assertNull(users);
    }
    @Test(expected = EntityNotFoundException.class)
    public void testDeleteNonExistUsers() {
        Integer userId=99;
        userDao.delete(userId);

    }

    @Test
    public void testListAll() {
        List<Users>list=userDao.listAll();
        list.forEach(users -> {
            System.out.println(users.getFullName()+" "+users.getEmail());
        });
        assertTrue(list.size()>0);
    }

    @Test
    public void testCount() {
        long total=userDao.count();
        assertTrue(total>0);
    }

    @Test
    public void testFindByEmail() {
        String email="test@gmail.com";
        Users users=userDao.findByEmail(email);
        assertNotNull(users);
    }

    @Test
    public void emailAndPassWord() {
        String email="k1@gmail.com";
        String password="1237";
        assertTrue(userDao.checkLogin(email,password));
    }

    @AfterClass
    public static void afterClass() throws Exception {
    	 userDao.close();
    }
}
