package web.spring_boot.springbootproject.lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FileReaderService {

    public List<String> getStringFromFile(String path) throws IOException {
        List<String>records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            throw new IOException("No such File", e);
        }
        return records;
    }
}
