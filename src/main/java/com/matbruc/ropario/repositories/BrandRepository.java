package com.matbruc.ropario.repositories;

import com.matbruc.ropario.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
