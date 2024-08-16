package com.example.apidemo.api.domain.person;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return  personRepository.findAll();
    }

    public Person findOneById(String id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.orElse(null);
    }
}
