package com.shoppingcart.service;

import com.shoppingcart.dao.UserDao;
import com.shoppingcart.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void registerUser(User user)
    {
        userDao.saveUser(user);
    }

    @Transactional
    public User checkLoginCredentials(String email, String password)
    {
        return userDao.checkLoginCredentials(email,password);
    }

}
