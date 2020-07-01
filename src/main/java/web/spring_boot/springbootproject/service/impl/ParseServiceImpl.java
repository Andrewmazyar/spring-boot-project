package web.spring_boot.springbootproject.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import web.spring_boot.springbootproject.dto.FileDto;
import web.spring_boot.springbootproject.service.ParseService;

@Service
public class ParseServiceImpl implements ParseService {
    private final int ID_ATTRIBUTE = 0;
    private final int PRODUCT_ID = 1;
    private final int USER_ID = 2;
    private final int PROFILE_NAME = 3;
    private final int HELP_FULLNESS_NUMERATOR = 4;
    private final int HELP_FULLNESS_DENOMINATOR = 5;
    private final int SCORE = 6;
    private final int TIME = 7;
    private final int SUMMARY = 8;
    private final int TEXT = 9;

    private final FileReaderServiceImpl fileReaderService;

    public ParseServiceImpl(FileReaderServiceImpl fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public List<FileDto> parse(String path) throws IOException {
        List<FileDto> fileDtos = new ArrayList<>();
        for (String data : fileReaderService.getStringFromFile(path)) {
            String[] arrayData = data.split(",");
            FileDto fileDto = new FileDto();
            fileDto.setId(Long.valueOf(arrayData[ID_ATTRIBUTE]));
            fileDto.setProductId(Long.valueOf(arrayData[PRODUCT_ID]));
            fileDto.setUserId(Long.valueOf(arrayData[USER_ID]));
            fileDto.setProfileName(arrayData[PROFILE_NAME]);
            fileDto.setHelpfulnessNumerator(Long.valueOf(arrayData[HELP_FULLNESS_NUMERATOR]));
            fileDto.setHelpfulnessDenominator(Long.valueOf(arrayData[HELP_FULLNESS_DENOMINATOR]));
            fileDto.setScore(Long.valueOf(arrayData[SCORE]));
            fileDto.setTime(Long.valueOf(arrayData[TIME]));
            fileDto.setSummary(arrayData[SUMMARY]);
            fileDto.setText(arrayData[TEXT]);
            fileDtos.add(fileDto);
        }
        return fileDtos;
    }
}
