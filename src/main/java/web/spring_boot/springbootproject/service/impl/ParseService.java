package web.spring_boot.springbootproject.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import web.spring_boot.springbootproject.dto.FileDto;

@Service
public class ParseService {
    private final FileReaderService fileReaderService;

    public ParseService(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public List<FileDto> parse(String path) throws IOException {
        List<FileDto> fileDtos = new ArrayList<>();
        for (String data : fileReaderService.getStringFromFile(path)) {
            FileDto fileDto = new FileDto();
            fileDto.setId(Long.valueOf(data.split(",")[0]));
            fileDto.setProductId(Long.valueOf(data.split(",")[1]));
            fileDto.setUserId(Long.valueOf(data.split(",")[2]));
            fileDto.setProfileName(data.split(",")[3]);
            fileDto.setHelpfulnessNumerator(Long.valueOf(data.split(",")[4]));
            fileDto.setHelpfulnessDenominator(Long.valueOf(data.split(",")[5]));
            fileDto.setScore(Long.valueOf(data.split(",")[6]));
            fileDto.setTime(Long.valueOf(data.split(",")[7]));
            fileDto.setSummary(data.split(",")[8]);
            fileDto.setText(data.split(",")[9]);
            fileDtos.add(fileDto);
        }
        return fileDtos;
    }
}
