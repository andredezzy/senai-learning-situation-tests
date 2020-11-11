package me.andredezzy.senai.service.impl.user;

import me.andredezzy.senai.model.person.Person;
import me.andredezzy.senai.service.CrudService;

import java.util.Optional;

public interface PersonService extends CrudService<Person> {

    Optional<Person> findByName(String name);
}
