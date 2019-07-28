package com.matbruc.ropario.controllers;

import com.matbruc.ropario.models.Fabric;
import com.matbruc.ropario.services.IFabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fabrics")
public class FabricController {

    @Autowired
    private IFabricService fabricService;

    @GetMapping
    public ResponseEntity<List<Fabric>> getAllFabrics() {
        List<Fabric> list = fabricService.getAllFabrics();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fabric> getFabricById(@PathVariable("id") long id) {
        Fabric fabric = fabricService.getFabricById(id);
        return new ResponseEntity<>(fabric, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addFabric(@RequestBody Fabric fabric, UriComponentsBuilder builder) {
        fabricService.addFabric(fabric);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/v1/fabrics").buildAndExpand(fabric.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Fabric> updateFabric(@RequestBody Fabric fabric) {
        fabricService.updateFabric(fabric);
        return new ResponseEntity<>(fabric, HttpStatus.OK);
    }

    @DeleteMapping("{id")
    public ResponseEntity<Void> deleteFabric(@PathVariable("id") long id) {
        fabricService.deleteFabric(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
