package web.springboot.springbootproject.service;

import java.io.IOException;
import java.util.List;

public interface FileReaderService {
    public List<String> getStringFromFile(String path) throws IOException;
}
