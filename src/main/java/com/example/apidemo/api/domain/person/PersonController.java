package com.example.apidemo.api.domain.person;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
@Slf4j
public class PersonController {

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        try {
            List<Person> people = new ArrayList<>();
            people.add(new Person("id1", "John Doe"));
            people.add(new Person("id2", "Adam Smith"));
            log.info("Get all people. Size: {}", people.size());
            return new ResponseEntity<>(people, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: [GET] /api/person ERROR: {}", e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

}
