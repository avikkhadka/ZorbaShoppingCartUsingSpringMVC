package com.shoppingcart.service;

import com.shoppingcart.dao.ProductDao;
import com.shoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    @Transactional
    public void addProduct(Product product)
    {
        productDao.saveProduct(product);
    }
    public List<Product> getAllProducts()
    {
        return productDao.getAllProducts();
    }
}

