package com.matbruc.ropario.controllers;

import com.matbruc.ropario.models.Gender;
import com.matbruc.ropario.services.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/v1/genders")
public class GenderController {

    @Autowired
    private IGenderService genderService;

    @GetMapping
    public ResponseEntity<List<Gender>> getAllGenders() {
        List<Gender> list = genderService.gatAllGenders();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id")
    public ResponseEntity<Gender> getGenderById(@PathVariable("id") long id) {
        Gender gender = genderService.getGenderById(id);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addGender(@RequestBody Gender gender, UriComponentsBuilder builder) {
        genderService.addGender(gender);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/v1/genders").buildAndExpand(gender.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Gender> updateGender(@RequestBody Gender gender) {
        genderService.updateGender(gender);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteGender(@PathVariable("id") long id) {
        genderService.deleteGender(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
