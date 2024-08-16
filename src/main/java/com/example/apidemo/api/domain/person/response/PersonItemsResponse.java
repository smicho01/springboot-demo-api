package com.example.apidemo.api.domain.person.response;

import com.example.apidemo.api.domain.item.Item;
import com.example.apidemo.api.domain.person.Person;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonItemsResponse {
    private Person person;
    private List<Item> items;
}
