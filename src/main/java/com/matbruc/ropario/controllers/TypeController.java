package com.matbruc.ropario.controllers;

import com.matbruc.ropario.models.Type;
import com.matbruc.ropario.services.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/types")
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @GetMapping
    public ResponseEntity<List<Type>> getAllTypes() {
        List<Type> list = typeService.getAllTypes();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id")
    public ResponseEntity<Type> getTypeById(@PathVariable("id") long id) {
        Type type = typeService.getTypeById(id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addType(@RequestBody Type type, UriComponentsBuilder builder) {
        typeService.addType(type);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/v1/types").buildAndExpand(type.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Type> updateType(@RequestBody Type type) {
        typeService.updateType(type);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteType(@PathVariable("id") long id) {
        typeService.deleteType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
