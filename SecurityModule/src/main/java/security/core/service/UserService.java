package security.core.service;

import io.jsonwebtoken.JwtException;
import security.core.dto.request.AuthRequest;
import security.core.dto.responce.AuthentificationDTO;
import security.core.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import security.core.repository.UserRepository;


@Service
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    JWTUtil JWTUtil;
    public void createUser (User user) {
        if (userRepository.existsByFirstName(user.getFirstName())) {
            throw new RuntimeException("Пользователь уже существует");

        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }
    public User getUser (String firstName) {
        return userRepository.findByFirstName(firstName).get();
    }
    public AuthentificationDTO authentificate (AuthRequest authRequest) {
        User user = userRepository.findByFirstName(authRequest.getLogin()).get();
        if (passwordEncoder.matches(user.getPassword(), authRequest.getPassword())) {
            String accessToken = JWTUtil.accessToken(user.getFirstName());
            String refreshToken = JWTUtil.generateRefreshJWTToken(user.getFirstName());
            return new AuthentificationDTO(accessToken, refreshToken);
        }
        else {
            throw new RuntimeException("Неверный пароль!");

        }
    }
    public boolean isValidToken (String token) {
        try {
            JWTUtil.validateToken(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
    public UserService (UserRepository userRepository,
                        PasswordEncoder passwordEncoder,
                        JWTUtil JWTUtil ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.JWTUtil = JWTUtil;

    }
}
