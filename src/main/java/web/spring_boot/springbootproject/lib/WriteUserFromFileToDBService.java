package web.spring_boot.springbootproject.lib;

import org.springframework.stereotype.Component;
import web.spring_boot.springbootproject.entity.User;
import web.spring_boot.springbootproject.service.UserServices;

@Component
public class WriteUserFromFileToDBService {
    private final UserServices userServices;

    public WriteUserFromFileToDBService(UserServices userServices) {
        this.userServices = userServices;
    }

    public void parseDataToDbService(String line) {
        String[] parseData = line.split(",");
        User user = new User();
        user.setId(Long.parseLong(parseData[2]));
        user.setNickName(parseData[3]);
        userServices.add(user);
    }
}
