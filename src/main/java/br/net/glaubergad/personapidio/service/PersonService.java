package br.net.glaubergad.personapidio.service;

import br.net.glaubergad.personapidio.dto.MessageResponseDto;
import br.net.glaubergad.personapidio.dto.PersonDto;
import br.net.glaubergad.personapidio.entity.Person;
import br.net.glaubergad.personapidio.exception.PersonNotFoundException;
import br.net.glaubergad.personapidio.mapper.PersonMapper;
import br.net.glaubergad.personapidio.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired) )
public class PersonService {


    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private final PersonRepository personRepository;


    public MessageResponseDto createPerson(PersonDto personDto) {
        Person personToSave = personMapper.toModel(personDto);
        Person savedPerson = personRepository.save(personToSave);
        return buildMessageDto(savedPerson.getId(), "Created person with ID:");
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
        verifyIfPersonExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDto putPerson(Long id, PersonDto personDto) throws PersonNotFoundException {
        verifyIfPersonExists(personDto.getId());
        Person personToUpdate = personMapper.toModel(personDto);
        personRepository.save(personToUpdate);
        return buildMessageDto(personToUpdate.getId(), "Updated person with ID:");
    }

    private MessageResponseDto buildMessageDto(Long id, String s) {
        return MessageResponseDto.builder()
                .message(s + id)
                .build();
    }

    private Person verifyIfPersonExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
