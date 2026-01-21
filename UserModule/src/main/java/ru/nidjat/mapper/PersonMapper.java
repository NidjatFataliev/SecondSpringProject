package ru.nidjat.mapper;

import ru.nidjat.dto.PersonDto;
import org.mapstruct.Mapper;
import ru.nidjat.entity.Person;


@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto personDto (Person person);

}
