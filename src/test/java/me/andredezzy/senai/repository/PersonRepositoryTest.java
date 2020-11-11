package me.andredezzy.senai.repository;

import me.andredezzy.senai.model.person.Person;
import me.andredezzy.senai.repository.impl.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    public void beforeEach() {
        personRepository.deleteAll();
    }

    @Test
    public void whenFindingUserById_thenCorrect() {
        Person createdPerson = personRepository.save(new Person("John", 18));

        Optional<Person> personOptional = personRepository.findById(createdPerson.getId());

        assertThat(personOptional).isPresent();
        assertThat(personOptional.get().getName()).isEqualTo("John");
        assertThat(personOptional.get().getAge()).isEqualTo(18);
    }

    @Test
    public void whenUpdateUserById_thenCorrect() {
        Person createdPerson = personRepository.save(new Person("John", 18));

        Optional<Person> personOptional = personRepository.findById(createdPerson.getId());

        assertThat(personOptional).isPresent();

        Person person = personOptional.get();

        assertThat(person.getName()).isEqualTo("John");
        assertThat(person.getAge()).isEqualTo(18);

        person.setAge(19);

        person = personRepository.save(person);

        assertThat(person.getName()).isEqualTo("John");
        assertThat(person.getAge()).isEqualTo(19);
    }

    @Test
    public void whenDeleteUserById_thenCorrect() {
        Person createdPerson = personRepository.save(new Person("John", 18));

        Optional<Person> personOptional = personRepository.findById(createdPerson.getId());

        assertThat(personOptional).isPresent();

        Person person = personOptional.get();

        personRepository.delete(person);

        personOptional = personRepository.findById(createdPerson.getId());

        assertThat(personOptional).isNotPresent();
    }
}
