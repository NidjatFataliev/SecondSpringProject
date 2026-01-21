/*
package ru.nidjat.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler (RuntimeException.class)
    @ResponseBody
    public String DataBaseException (RuntimeException e) {
            return "Ошибка";

    }
    @ExceptionHandler (CustomException.class)
    @ResponseBody
    public String UserNotFoundException (CustomException e) {
        return "Ошибка: " + e.getMessage();

    }

}


*/
