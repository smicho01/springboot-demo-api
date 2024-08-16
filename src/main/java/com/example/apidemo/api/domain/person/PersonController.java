package com.example.apidemo.api.domain.person;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
@Slf4j
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        try {
            List<Person> people = personService.findAll();
            log.info("Get all people. Size: {}", people.size());
            return new ResponseEntity<>(people, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: [GET] /api/person ERROR: {}", e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getOne(@PathVariable(name = "id") String id) {
        try {
            Person person = personService.findOneById(id);
            log.info("Get person by id: {}", id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: [GET] /api/person/{} ERROR: {}",id, e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
