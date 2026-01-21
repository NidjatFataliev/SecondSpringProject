package ru.nidjat.exceptions;

public class CustomException extends RuntimeException {
    public CustomException () {
        super ("Пользователь не найден!");
    }

}
