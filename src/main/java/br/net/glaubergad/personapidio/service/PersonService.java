package br.net.glaubergad.personapidio.service;

import br.net.glaubergad.personapidio.dto.MessageResponseDto;
import br.net.glaubergad.personapidio.entity.Person;
import br.net.glaubergad.personapidio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDto personSave(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDto.builder()
                .message("Created person with ID:" + savedPerson.getId())
                .build();
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
