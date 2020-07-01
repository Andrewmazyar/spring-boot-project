package web.spring_boot.springbootproject.controllers.mappers;

import org.springframework.stereotype.Component;
import web.spring_boot.springbootproject.dto.FileDto;
import web.spring_boot.springbootproject.entity.User;

@Component
public class MapperFileDtoToUser {
    public User convertToUser(FileDto fileDto) {
        User user = new User();
        user.setNickName(fileDto.getProfileName());
        user.setId(fileDto.getUserId());
        return user;
    }
}
