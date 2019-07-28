package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand> getAllBrands();
    Brand getBrandById(long brandId);
    void addBrand(Brand brand);
    void updateBrand(Brand brand);
    void deleteBrand(long brandId);
}
