package br.net.glaubergad.personapidio.controller;

import br.net.glaubergad.personapidio.dto.MessageResponseDto;
import br.net.glaubergad.personapidio.entity.Person;
import br.net.glaubergad.personapidio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public String getPersonById() {
        return "GetPeople By ID";
    }

    @PostMapping
    public MessageResponseDto postPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDto.builder()
                .message("Created person with ID:" + savedPerson.getId())
                .build();
    }

    @PutMapping("/{id}")
    public String putPerson() {
        return "API Test";
    }

    @DeleteMapping("/{id}")
    public String deletePerson() {
        return "API Test";
    }

}
