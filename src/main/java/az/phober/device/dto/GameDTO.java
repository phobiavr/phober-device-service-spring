package az.phober.device.dto;

import az.phober.device.entity.Game;
import az.phober.media.MediaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

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

    private List<MediaDTO> media;

    public static GameDTO dtoMapper(Game entity) {
        return new GameDTO(
                entity.getId(),
                entity.getName(),
                entity.getSlug(),
                entity.getVideo(),
                entity.getDescription(),
                entity.getRating(),
                entity.getMultiplayer(),
                entity.getUpdatedAt(),
                entity.getCreatedAt(),
                null);
    }
}
