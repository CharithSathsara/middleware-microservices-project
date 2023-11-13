package lk.sritel.sricare.authenticationservice.service;

import lk.sritel.sricare.authenticationservice.model.User;
import lk.sritel.sricare.authenticationservice.repository.UserRepository;
import lk.sritel.sricare.authenticationservice.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AuthResponse registerUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return new AuthResponse("User registered successfully",  HttpStatus.CREATED,  user);
        } catch (Exception e) {
            return new AuthResponse("Error registering user", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    public AuthResponse loginUser(String phone, String password) {
        try {
            User user = userRepository.findByPhone(phone);
            if (user != null && passwordEncoder.matches(password, user.getPassword())) {
                return new AuthResponse("Login successful",  HttpStatus.FOUND, user);
            } else {
                return new AuthResponse("Invalid credentials", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return new AuthResponse("Error logging in", HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

}
