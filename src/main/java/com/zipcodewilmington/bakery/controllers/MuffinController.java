package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MuffinController {
    @Autowired //asks Spring to wire a dependency into a class from the Application Contex
    private MuffinService service;

    public MuffinController(MuffinService service) {
        this.service = service;
    }
    @GetMapping("/muffins")
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    @GetMapping("/muffins/{id}")//(endpoints) the path to make the getting of a muffin's ID happen
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    @PostMapping("/muffins") //request body is making sure we are getting all required fields to create a new object
    public ResponseEntity<Muffin> create(@RequestBody Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
    @PutMapping("/muffin/{id}")
    public ResponseEntity<Muffin> update(@PathVariable Long id,@RequestBody Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
    @DeleteMapping("/muffin/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
/*RequestMapping defaults to RequestMethod.GET for its verb, but can take any verb supported by HTTP.
 The main ones are GET(read), PUT(update), POST(create), and DELETE(destroy/delete).*/