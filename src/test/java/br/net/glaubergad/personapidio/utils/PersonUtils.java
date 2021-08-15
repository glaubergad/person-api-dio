package br.net.glaubergad.personapidio.utils;

import br.net.glaubergad.personapidio.dto.PersonDto;
import br.net.glaubergad.personapidio.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    public static final LocalDate BIRTH_DATE = LocalDate.of(1976, 12, 15);
    private static final String FIRST_NAME = "João";
    private static final String LAST_NAME = "Batista";
    private static final String CPF = "39945670174";
    private static final long PERSON_ID = 1L;

    public static PersonDto createFakeDto() {
        return PersonDto.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate("15-12-1976")
                .phones(Collections.singletonList(PhoneUtils.createFakeDto()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
