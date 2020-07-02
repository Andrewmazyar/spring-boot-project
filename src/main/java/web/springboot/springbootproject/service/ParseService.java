package web.springboot.springbootproject.service;

import java.io.IOException;
import java.util.List;
import web.springboot.springbootproject.dto.FileDto;

public interface ParseService {
    public List<FileDto> parse(String path) throws IOException;
}
