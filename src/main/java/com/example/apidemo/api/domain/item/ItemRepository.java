package com.example.apidemo.api.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, String> {

    List<Item> findByUserId(String userId);

}
