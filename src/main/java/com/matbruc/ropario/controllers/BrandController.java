package com.matbruc.ropario.controllers;

import com.matbruc.ropario.models.Brand;
import com.matbruc.ropario.services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> list = brandService.getAllBrands();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("id") long id) {
        Brand brand= brandService.getBrandById(id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addBrand(@RequestBody Brand brand, UriComponentsBuilder builder) {
        brandService.addBrand(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/v1/brands").buildAndExpand(brand.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Brand> updateBrand(@RequestBody Brand brand) {
        brandService.updateBrand(brand);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") long id) {
        brandService.deleteBrand(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
