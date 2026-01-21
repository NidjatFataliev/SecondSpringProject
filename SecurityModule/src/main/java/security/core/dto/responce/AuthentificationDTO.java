package security.core.dto.responce;
import java.time.LocalDateTime;

public class AuthentificationDTO {
    private String accessToken;
    private String refreshToken;
    private LocalDateTime localDateTime;

    public AuthentificationDTO(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        localDateTime = LocalDateTime.now();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
