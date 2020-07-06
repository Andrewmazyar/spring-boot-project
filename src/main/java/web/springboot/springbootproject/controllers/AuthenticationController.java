package web.springboot.springbootproject.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.springboot.springbootproject.dto.RegistrationDto;
import web.springboot.springbootproject.security.AuthenticationService;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegistrationDto registrationDto) {
        authenticationService.register(registrationDto.getUserName(),
                registrationDto.getPassword());
    }
}
