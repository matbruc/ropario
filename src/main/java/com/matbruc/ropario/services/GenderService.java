package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Gender;
import com.matbruc.ropario.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderService implements IGenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Override
    public List<Gender> gatAllGenders() {
        List<Gender> list = new ArrayList<>();
        genderRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Gender getGenderById(long genderId) {
        return genderRepository.findById(genderId).get();
    }

    @Override
    public void addGender(Gender gender) {
        genderRepository.save(gender);
    }

    @Override
    public void updateGender(Gender gender) {
        genderRepository.save(gender);
    }

    @Override
    public void deleteGender(long genderId) {
        genderRepository.delete(getGenderById(genderId));
    }

}
