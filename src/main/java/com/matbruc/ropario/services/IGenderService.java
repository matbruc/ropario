package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Gender;

import java.util.List;

public interface IGenderService {
    List<Gender> gatAllGenders();
    Gender getGenderById(long genderId);
    void addGender(Gender gender);
    void updateGender(Gender gender);
    void deleteGender(long genderId);
}
