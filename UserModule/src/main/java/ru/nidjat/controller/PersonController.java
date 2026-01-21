package ru.nidjat.controller;

import ru.nidjat.dto.PersonDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nidjat.entity.Person;
import ru.nidjat.service.PersonService;
import ru.nidjat.service.UserServiceProducer;

/**
 * Javadoc PersonController
 * Эндпоинты для работы с классом Person
 */
@RestController
public class PersonController {
    PersonService personService;
    UserServiceProducer userServiceProducer;
    public PersonController (PersonService personService, UserServiceProducer userServiceProducer) {
        this.personService = personService;
        this.userServiceProducer = userServiceProducer;

    }


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation (summary = "Добавление пользователя в БД")
    @ApiResponse (responseCode = "404", description = "Ошибка! Добавление пользователя не выполнено!")

    public String postPerson(@Parameter (description = "Описание пользователя") @RequestBody Person person) {
        personService.postPerson(person);
        userServiceProducer.sendUserMessage("Это сообщение из Продюсера!");
        return "Пользователь " + person.getName() + " успешно добавлен!";

    }

    @GetMapping("/persons")
    public String getPerson() {
        return personService.getPerson();
    }

    @GetMapping("/persons/id/{id}")
    public ResponseEntity<?> getPersonId(@PathVariable int id) {
    return personService.getPersonId(id);
    }
    @GetMapping ("/test2")
        public String getTestException () {
       return personService.testMethod();
    }
    @GetMapping ("/test3")
    public String getTestException2 () {
        return personService.exceptionMethod();
    }

    @GetMapping ("/map")
    public PersonDto mapPersonToDto (@RequestBody Person person) {
        return personService.fromPersonToDto(person);

    }


}

