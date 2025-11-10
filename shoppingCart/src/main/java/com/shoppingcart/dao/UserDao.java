package com.shoppingcart.dao;

import com.shoppingcart.model.User;

public interface UserDao {
    void saveUser(User user);
    User checkLoginCredentials(String email, String password);
}
