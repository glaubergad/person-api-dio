package br.net.glaubergad.personapidio.mapper;

import br.net.glaubergad.personapidio.dto.PersonDto;
import br.net.glaubergad.personapidio.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source="birthDate", target="birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDto personDto);

    PersonDto toDto(Person person);

}
