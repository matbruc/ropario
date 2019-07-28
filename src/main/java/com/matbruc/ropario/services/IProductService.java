package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(long productId);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(long productId);
}
