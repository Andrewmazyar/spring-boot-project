package web.springboot.springbootproject.controllers;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.springboot.springbootproject.config.JwtTokenProvider;
import web.springboot.springbootproject.dto.RegistrationDto;
import web.springboot.springbootproject.dto.UserRequestDto;
import web.springboot.springbootproject.entity.User;
import web.springboot.springbootproject.security.AuthenticationService;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationService authenticationService,
                                    JwtTokenProvider jwtTokenProvider) {
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegistrationDto registrationDto) {
        authenticationService.register(registrationDto.getUserName(),
                registrationDto.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserRequestDto userLoginDto) {
        User user = authenticationService.login(userLoginDto.getLogin(),
                userLoginDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles().stream()
                .map(role -> role.getRoleName().name())
                .collect(Collectors.toList()));
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
