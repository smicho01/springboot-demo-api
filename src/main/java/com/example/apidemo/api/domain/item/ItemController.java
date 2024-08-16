package com.example.apidemo.api.domain.item;

import com.example.apidemo.api.domain.person.Person;
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
@RequestMapping("/api/item")
@Slf4j
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping
    public ResponseEntity<List<Item>> getAll() {
        try {
            List<Item> items = itemService.findAll();
            log.info("Get all items. Size: {}", items.size());
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: [GET] /api/item ERROR: {}", e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<List<Item>> getPersonItems(@PathVariable(name = "id") String personId) {
        try {
            List<Item> personItems = itemService.getUserItems(personId);
            log.info("Get person items. Person id: {}", personId);
            return new ResponseEntity<>(personItems, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: [GET] /api/person/items/{} ERROR: {}",personId, e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
