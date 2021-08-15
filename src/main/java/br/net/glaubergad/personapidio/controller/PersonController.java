package br.net.glaubergad.personapidio.controller;

import br.net.glaubergad.personapidio.dto.MessageResponseDto;
import br.net.glaubergad.personapidio.dto.PersonDto;
import br.net.glaubergad.personapidio.exception.PersonNotFoundException;
import br.net.glaubergad.personapidio.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired) )
public class PersonController {

    private final PersonService personService;


    @GetMapping
    public List<PersonDto> getPersonList() {
        return personService.getPersonList();
    }

    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.getPersonById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto postPerson(@RequestBody @Valid PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDto putPerson(@PathVariable Long id, @RequestBody @Valid PersonDto personDto) throws PersonNotFoundException{

        return personService.putPerson(id,personDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id) throws PersonNotFoundException {
        personService.deletePerson(id);
    }

}
