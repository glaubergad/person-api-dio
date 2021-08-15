package br.net.glaubergad.personapidio.service;

import br.net.glaubergad.personapidio.dto.MessageResponseDto;
import br.net.glaubergad.personapidio.dto.PersonDto;
import br.net.glaubergad.personapidio.entity.Person;
import br.net.glaubergad.personapidio.exception.PersonNotFoundException;
import br.net.glaubergad.personapidio.mapper.PersonMapper;
import br.net.glaubergad.personapidio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {


    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }




    public MessageResponseDto createPerson(PersonDto personDto) {
        Person personToSave = personMapper.toModel(personDto);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDto.builder()
                .message("Created person with ID:" + savedPerson.getId())
                .build();
    }

    public List<PersonDto> getPersonList() {

        return personRepository
                .findAll()
                .stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    public PersonDto getPersonById(Long id) throws PersonNotFoundException {
        Person person = verifyIfPersonExists(id);
        return personMapper.toDto(person);
    }



    public void deletePerson(Long id) throws PersonNotFoundException {
        Person person = verifyIfPersonExists(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfPersonExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));
    }
}
