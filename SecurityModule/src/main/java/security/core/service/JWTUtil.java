package security.core.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JWTUtil {
    private final String secretKey;
    public JWTUtil (@Value("${jwt.secret}") String jwtUtil) {
        this.secretKey = jwtUtil;

    }
    public SecretKey getSecretkey () {
       byte [] keybytes = Decoders.BASE64.decode(secretKey);
       return Keys.hmacShaKeyFor(keybytes);
    }
    public String generateRefreshJWTToken (String userName) {
        Date date = Date.from(LocalDateTime.now().plusDays(14).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder().subject(userName).expiration(date).signWith(getSecretkey()).compact();
    }
    public String accessToken (String userName) {
        Date date = Date.from(LocalDateTime.now().plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder().subject(userName).expiration(date).signWith(getSecretkey()).compact();


    }
    public Jws<Claims> validateToken (final String token) {
        return Jwts.parser().verifyWith(getSecretkey()).build().parseSignedClaims(token);

    }

}
