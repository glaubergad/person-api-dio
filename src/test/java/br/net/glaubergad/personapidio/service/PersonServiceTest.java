package br.net.glaubergad.personapidio.service;

import br.net.glaubergad.personapidio.dto.MessageResponseDto;
import br.net.glaubergad.personapidio.dto.PersonDto;
import br.net.glaubergad.personapidio.entity.Person;
import br.net.glaubergad.personapidio.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.net.glaubergad.personapidio.utils.PersonUtils.createFakeDto;
import static br.net.glaubergad.personapidio.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenDtoReturnSaveMessage() {
        PersonDto personDto = createFakeDto();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDto expectedSuccessMessage = createExpectedMessageResponse(1L);
        MessageResponseDto successMessage = personService.createPerson(personDto);

        assertEquals(expectedSuccessMessage,successMessage);
    }

    private MessageResponseDto createExpectedMessageResponse(Long id) {
        return MessageResponseDto.builder()
                .message("Created person with ID:" + id)
                .build();
    }
}
