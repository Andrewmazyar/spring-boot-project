package web.springboot.springbootproject.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import web.springboot.springbootproject.service.FileReaderService;

@Service
public class FileReaderServiceImpl implements FileReaderService {

    public List<String> getStringFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            throw new IOException("No such File", e);
        }
    }
}
