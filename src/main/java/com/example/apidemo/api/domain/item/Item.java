package com.example.apidemo.api.domain.item;

import lombok.*;
import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Item {
    @Id
    private String id;
    private String name;
    private double price;
    private String userId;
}
