package web.spring_boot.springbootproject.controllers;

import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import web.spring_boot.springbootproject.lib.FileReaderService;

public class InjectDataController {
    private final String ROUTE = "/home/user/IdeaProjects/Reviews.csv";

    private final FileReaderService fileReaderService;

    public InjectDataController(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    @SneakyThrows
    @PostConstruct
    public void init() {
        fileReaderService.getStringFromFile(ROUTE);
    }
}
