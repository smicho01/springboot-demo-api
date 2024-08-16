package com.example.apidemo.api.domain.person;

import com.example.apidemo.api.domain.item.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonService {

    private final RestTemplate restTemplate;
    private final PersonRepository personRepository;

    @Value("${app.api.endpoint.item}")
    private String apiItemEndpointUrl;

    public PersonService(RestTemplate restTemplate, PersonRepository personRepository) {
        this.restTemplate = restTemplate;
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return  personRepository.findAll();
    }

    public Person findOneById(String id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.orElse(null);
    }

    public List<Item> getPersonItems(String personId) {
        try {
            log.info("Get person items via rest template");
            String endpointUrl = apiItemEndpointUrl + "/api/item/person/" + personId;
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<List<Item>> response = restTemplate.exchange(
                    endpointUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Item>>() {
                    });
            List<Item> personItems = response.getBody();
            if (personItems != null) {
                log.info("Found person items via rest template. Count: {}", personItems.size());
                return personItems;
            }
            return new ArrayList<>();
        } catch (Exception e) {
            log.error("Error while getting person items via rest template. ERROR: {}", e.getMessage());
            return new ArrayList<>();
        }
    }
}
