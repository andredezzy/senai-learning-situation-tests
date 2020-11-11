package me.andredezzy.senai.service;

import me.andredezzy.senai.model.person.Person;
import me.andredezzy.senai.service.impl.user.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService userService;

    @Test
    public void whenSaveUser_thenCorrect() {
        Person person = new Person("John", 18);

        Optional<Person> createdUser = userService.save(person);

        assertThat(createdUser.isPresent()).isTrue();

        Optional<Person> findUser = userService.findById(createdUser.get().getId());

        assertThat(findUser.isPresent()).isTrue();
        assertThat(findUser.get().getName()).isEqualTo("John");
        assertThat(findUser.get().getAge()).isEqualTo(18);
    }
}
