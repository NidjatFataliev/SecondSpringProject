package ru.nidjat.service;


import ru.nidjat.dto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.nidjat.entity.Person;
import ru.nidjat.exceptions.CustomException;
import ru.nidjat.mapper.PersonMapper;
import ru.nidjat.repository.UserRepository;
import ru.nidjat.response.PersonResponseDTO;

import java.util.ArrayList;

@Service
public class PersonService  {
    PersonMapper personMapper;
    ArrayList<Person> persons = new ArrayList<>();
    UserRepository userRepository;
    public PersonService(UserRepository userRepository, PersonMapper personMapper) {
        this.userRepository = userRepository;
        this.personMapper = personMapper;

    }
    public PersonDto fromPersonToDto (Person person) {
    return personMapper.personDto(person);

    }


    public String postPerson(Person person) {
        persons.add(person);
        userRepository.save(person);
        return "Пользователь " + person.getName() + " успешно добавлен!";
    }
    public String getPerson() {
        return persons.toString();

    }
    /**
     * Javadoc PersonController
     * Метод для получения пользователя по ID
     * @param id уникальный идентификатор пользователя нужно обязательно указать параметр @param name иначе не сработает
     * @return возвращает имя personDTO в котором прописаны ID и имя пользователя
     * @see ru.nidjat.controller.PersonController
     */
    public ResponseEntity<?> getPersonId(int id) {
        try {
            Person person = persons.stream().filter(element -> element.getId() == id).findFirst().get();
            PersonResponseDTO personResponseDTO = new PersonResponseDTO(person.getId(), person.getName());
            return ResponseEntity.status(HttpStatus.FOUND).body(personResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Пользователь не найден!");
        }
        }
    /**
     * Javadoc PersonController
     * Тестовый метод для проверки работоспособности
     * @throws RuntimeException выкидывает исключение если ID не существует
     */
        public String testMethod() {
        throw new RuntimeException();
    }

    public String exceptionMethod () {
        throw new CustomException();
    }


}
