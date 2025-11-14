package com.shoppingcart.service;

import com.shoppingcart.dao.UserDao;
import com.shoppingcart.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Add this

    @Transactional
    public void registerUser(User user) {
        // Encode password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userDao.saveUser(user);
    }


}
