package com.shoppingcart.dao;

import com.shoppingcart.dao.UserDao;
import com.shoppingcart.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveUser(User user) {
        Session session=sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    @Transactional
    public User checkLoginCredentials(String email, String password) {
        Session session=sessionFactory.getCurrentSession();
        return session.createQuery(
                        "FROM User WHERE email = :email AND password = :pwd", User.class)
                .setParameter("email", email)
                .setParameter("pwd", password)
                .uniqueResult();
    }
}
