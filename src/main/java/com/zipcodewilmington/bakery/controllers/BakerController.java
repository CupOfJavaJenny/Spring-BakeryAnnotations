package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BakerController {
    @Autowired //asks Spring to wire a dependency into a class from the Application Context
    private BakerService service;

    public BakerController(BakerService service) {this.service = service;}
    @GetMapping("/bakers")
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    @GetMapping("/bakers/{id}")//(endpoints) the path to make the getting of a baker's ID happen
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    @PostMapping("/bakers") //request body is making sure we are getting all required fields to create a new object
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
    @PutMapping("/baker/{id}") //
    public ResponseEntity<Baker> update(@PathVariable Long id,@RequestBody Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
    @DeleteMapping("/baker/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
/*RequestMapping defaults to RequestMethod.GET for its verb, but can take any verb supported by HTTP.
 The main ones are GET(read), PUT(update), POST(create), and DELETE(destroy/delete).*/