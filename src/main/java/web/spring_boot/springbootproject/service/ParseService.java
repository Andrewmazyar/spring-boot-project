package web.spring_boot.springbootproject.service;

import java.io.IOException;
import java.util.List;
import web.spring_boot.springbootproject.dto.FileDto;

public interface ParseService {
    public List<FileDto> parse(String path) throws IOException;
}
