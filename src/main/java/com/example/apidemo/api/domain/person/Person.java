package com.example.apidemo.api.domain.person;


import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Person {

    @Id
    private String id;
    private String name;
}
