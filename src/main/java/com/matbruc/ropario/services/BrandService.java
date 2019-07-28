package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Brand;
import com.matbruc.ropario.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService implements IBrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        List<Brand> list = new ArrayList<>();
        brandRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Brand getBrandById(long brandId) {
        return brandRepository.findById(brandId).get();
    }

    @Override
    public void addBrand(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(long brandId) {
        brandRepository.delete(getBrandById(brandId));
    }
}
