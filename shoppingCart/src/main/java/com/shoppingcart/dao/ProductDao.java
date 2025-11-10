package com.shoppingcart.dao;

import com.shoppingcart.model.Product;

import java.util.List;

public interface ProductDao {
    void saveProduct(Product product);
    List<Product> getAllProducts();


}
