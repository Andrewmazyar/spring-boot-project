package web.spring_boot.springbootproject.dto;

import lombok.Data;

@Data
public class FileDto {
    private Long id;
    private Long productId;
    private Long userId;
    private String profileName;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private Long time;
    private String summary;
    private String text;
}
