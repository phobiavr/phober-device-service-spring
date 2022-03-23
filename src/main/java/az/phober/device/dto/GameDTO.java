package az.phober.device.dto;

import az.phober.device.entity.Game;
import az.phober.media.MediaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<GenreDTO> genres;

    private List<DeviceDTO> devices;

    public static GameDTO dtoMapper(Game entity) {
        String videoUrl = Game.VIDEO_URL_PREFIX.concat(entity.getVideo());

        List<GenreDTO> genres = !entity.getGenres().isEmpty() ?
                entity.getGenres().stream().map(GenreDTO::dtoMapper).collect(Collectors.toList()) :
                Collections.emptyList();

        List<DeviceDTO> devices = !entity.getDevices().isEmpty() ?
                entity.getDevices().stream().map(DeviceDTO::dtoMapper).collect(Collectors.toList()) :
                Collections.emptyList();

        return new GameDTO(
                entity.getId(),
                entity.getName(),
                entity.getSlug(),
                videoUrl,
                entity.getDescription(),
                entity.getRating(),
                entity.getMultiplayer(),
                null,
                genres,
                devices);
    }
}
