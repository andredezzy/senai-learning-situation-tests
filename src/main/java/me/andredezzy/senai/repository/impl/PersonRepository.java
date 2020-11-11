package me.andredezzy.senai.repository.impl;

import me.andredezzy.senai.model.person.Person;
import me.andredezzy.senai.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends BaseRepository<Person> {

    Optional<Person> findByName(String name);
}
