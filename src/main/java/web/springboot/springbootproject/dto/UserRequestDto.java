package web.springboot.springbootproject.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private final String login;
    private final String password;
}
