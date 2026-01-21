package ru.nidjat.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.mapstruct.Mapper;


@Entity

public class Person {
    @Schema (name = "name", example = "20", description = "Имя пользователя")
    private String name;

    @Schema (name = "age", example = "18", description = "Возраст пользователя")
    private int age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (name = "id", example = "15", description = "ID пользователя, ключ для базы")
    private int id;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person () {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

