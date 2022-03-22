package az.phober.device.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class GameDTO {
    private Long id;

    private String name;

    private String slug;

    private String video;

    private String description;

    private Integer rating;

    private Boolean multiplayer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
}
