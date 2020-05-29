package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(long productId);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(long productId);
}
