package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Age;

import java.util.List;

public interface IAgeService {
    List<Age> getAllAges();
    Age getAgeById(long ageId);
    void addAge(Age age);
    void updateAge(Age age);
    void deleteAge(long ageId);
}
