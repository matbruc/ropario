package com.matbruc.ropario.repositories;

import com.matbruc.ropario.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
