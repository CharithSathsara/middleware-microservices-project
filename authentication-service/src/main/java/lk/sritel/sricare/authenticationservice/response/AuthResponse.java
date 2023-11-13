package lk.sritel.sricare.authenticationservice.response;

import lk.sritel.sricare.authenticationservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String message;
    private HttpStatus status;
    private User user;

}
