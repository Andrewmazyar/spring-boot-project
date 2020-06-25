package web.spring_boot.springbootproject.controllers;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import web.spring_boot.springbootproject.controllers.mappers.MapperFileDtoToUser;
import web.spring_boot.springbootproject.entity.User;
import web.spring_boot.springbootproject.service.UserServices;
import web.spring_boot.springbootproject.service.impl.ParseService;

public class InjectDataController {
    private final String ROUTE = "/home/user/IdeaProjects/Reviews.csv";

    private final ParseService parseService;
    private final MapperFileDtoToUser mapperFileDtoToUser;
    private final UserServices userServices;

    public InjectDataController(ParseService parseService,
                                MapperFileDtoToUser mapperFileDtoToUser,
                                UserServices userServices) {
        this.parseService = parseService;
        this.mapperFileDtoToUser = mapperFileDtoToUser;
        this.userServices = userServices;
    }

    @SneakyThrows
    @PostConstruct
    public void init() {
        List<User> users = parseService.parse(ROUTE)
                .stream()
                .map(mapperFileDtoToUser::convertToUser)
                .map(userServices::add)
                .collect(Collectors.toList());
    }
}
