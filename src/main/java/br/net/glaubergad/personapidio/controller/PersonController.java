package br.net.glaubergad.personapidio.controller;

import br.net.glaubergad.personapidio.dto.MessageResponseDto;
import br.net.glaubergad.personapidio.entity.Person;
import br.net.glaubergad.personapidio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersonList() {
        return personService.getPersonList();
    }

    @GetMapping("/{id}")
    public String getPersonById() {
        return "GetPeople By ID";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto postPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public String putPerson() {
        return "putPerson";
    }

    @DeleteMapping("/{id}")
    public String deletePerson() {
        return "deletePerson";
    }

}
