package com.matbruc.ropario.repositories;

import com.matbruc.ropario.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
