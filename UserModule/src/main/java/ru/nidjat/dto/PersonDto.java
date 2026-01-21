package ru.nidjat.dto;


import ru.nidjat.entity.Person;

public class PersonDto {
    String name;
    int age;
    String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(Person person) {
        this.name = person.getName();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Person person) {
        this.age = person.getAge();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PersonDto (String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
    }
}
