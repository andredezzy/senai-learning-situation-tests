package me.andredezzy.senai.model.person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.andredezzy.senai.model.AbstractModel;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "people")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class Person extends AbstractModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}