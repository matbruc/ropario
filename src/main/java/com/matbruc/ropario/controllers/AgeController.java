package com.matbruc.ropario.controllers;

import com.matbruc.ropario.models.Age;
import com.matbruc.ropario.services.IAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/v1/ages")
public class AgeController {

    @Autowired
    private IAgeService ageService;

    @GetMapping
    public ResponseEntity<List<Age>> getAllAges() {
        List<Age> list = ageService.getAllAges();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Age> getAgeById(@PathVariable("id") long id) {
        Age age = ageService.getAgeById(id);
        return new ResponseEntity<>(age, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addAge(@RequestBody Age age, UriComponentsBuilder builder) {
        ageService.addAge(age);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/v1/ages").buildAndExpand(age.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Age> updateAge(@RequestBody Age age) {
        ageService.updateAge(age);
        return new ResponseEntity<>(age, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAge(@PathVariable("id") long id) {
        ageService.deleteAge(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
