package web.spring_boot.springbootproject.lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FileReaderService {

    private final WriteUserFromFileToDBService writeUserFromFileToDBService;

    public FileReaderService(WriteUserFromFileToDBService writeUserFromFileToDBService) {
        this.writeUserFromFileToDBService = writeUserFromFileToDBService;
    }

    public void getStringFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                writeUserFromFileToDBService.parseDataToDbService(line);
            }
        } catch (IOException e) {
            throw new IOException("No such File", e);
        }
    }
}
