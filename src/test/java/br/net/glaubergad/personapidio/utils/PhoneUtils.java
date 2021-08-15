package br.net.glaubergad.personapidio.utils;

import br.net.glaubergad.personapidio.dto.PhoneDto;
import br.net.glaubergad.personapidio.entity.Phone;
import br.net.glaubergad.personapidio.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "(91)99999-9900";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID= 1L;

    public static PhoneDto createFakeDto(){
        return PhoneDto.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity(){
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }



}

