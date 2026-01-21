package ru.nidjat.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/test")
public class TestController {
    List <String> names = new ArrayList<>();
    @GetMapping
public String test () {
    return "Hello world from Spring!";
}
    @GetMapping ("/test2")
    public String test2 () {
        return "Hello world from Spring!";
    }
    @PostMapping
    public String createUser (@RequestParam String name) {
        names.add(name);
        return "Успешно был создан пользователь: " + name;

    }
}
