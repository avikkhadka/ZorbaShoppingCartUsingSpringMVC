package com.shoppingcart.dao;

import com.shoppingcart.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession().createQuery("From Product",Product.class).list();
    }

}
