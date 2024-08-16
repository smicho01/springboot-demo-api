package com.example.apidemo.api.domain.item;

import com.example.apidemo.api.domain.person.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getUserItems(String userId) {
        log.info("Call ItemService/getUserItems");
        try {
            return itemRepository.findByUserId(userId);
        } catch (Exception e) {
            log.error("Error on ItemService/getUserItems  ERROR: {}", e.getMessage());
            return null;
        }
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
