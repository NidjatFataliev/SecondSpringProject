package security.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.core.dto.request.AuthRequest;
import security.core.dto.responce.AuthentificationDTO;
import security.core.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import security.core.service.UserService;

@RestController
@RequestMapping ("/auth")
public class UserController {

    UserService userService;
    public UserController (UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    @ResponseStatus (value = HttpStatus.CREATED)
    @Operation (summary = "Проверка наличия пользователя в базе и выдача ошибки при его наличии")
    public void saveUser (@RequestBody User user) {
        userService.createUser(user);

    }
    @PostMapping ("/createUser")
    public User createUser (User user) {
        userService.createUser(user);
        return user;
    }
    @PostMapping ("/auth2")
    public AuthentificationDTO authenticate (AuthRequest authRequest) {
        return userService.authentificate(authRequest);

    }
    @GetMapping ("/Hello")
    public ResponseEntity <String> sayHello () {
        return ResponseEntity.ok("Hello") ;
    }
    @GetMapping
    public boolean isValidToken (String token) {
        return userService.isValidToken(token);
    }
/*    @PostMapping ("/users")*/

}
