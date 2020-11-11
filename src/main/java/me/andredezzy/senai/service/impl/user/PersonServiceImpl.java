package me.andredezzy.senai.service.impl.user;

import me.andredezzy.senai.model.person.Person;
import me.andredezzy.senai.repository.impl.PersonRepository;
import me.andredezzy.senai.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl extends BaseService<Person> implements PersonService {

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Person> findByName(String name) {
        return ((PersonRepository) repository).findByName(name);
    }
}
