package lk.sritel.sricare.authenticationservice.controller;

import lk.sritel.sricare.authenticationservice.model.User;
import lk.sritel.sricare.authenticationservice.request.UserLoginRequest;
import lk.sritel.sricare.authenticationservice.response.AuthResponse;
import lk.sritel.sricare.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public AuthResponse registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody UserLoginRequest request) {
        return userService.loginUser(request.getUsername(), request.getPassword());
    }

}
