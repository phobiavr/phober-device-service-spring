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

    private String videoUrl;

    private String description;

    private Integer rating;

    private Boolean multiplayer;

    private List<MediaDTO> media;

    public static GameDTO dtoMapper(Game entity) {
        String videoUrl = Game.VIDEO_URL_PREFIX.concat(entity.getVideo());

        return new GameDTO(
                entity.getId(),
                entity.getName(),
                entity.getSlug(),
                videoUrl,
                entity.getDescription(),
                entity.getRating(),
                entity.getMultiplayer(),
                null);
    }
}
