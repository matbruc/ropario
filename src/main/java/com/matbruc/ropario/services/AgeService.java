package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Age;
import com.matbruc.ropario.repositories.AgeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgeService implements IAgeService {

    @Autowired
    private AgeRespository ageRespository;

    @Override
    public List<Age> getAllAges() {
        List<Age> list = new ArrayList<>();
        ageRespository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Age getAgeById(long ageId) {
        return ageRespository.findById(ageId).get();
    }

    @Override
    public Age addAge(Age age) {
        return ageRespository.save(age);
    }

    @Override
    public Age updateAge(Age age) {
        return ageRespository.save(age);
    }

    @Override
    public void deleteAge(long ageId) {
        ageRespository.delete(getAgeById(ageId));
    }

}
