package az.phober.device.dto;

import az.phober.device.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GenreDTO {
    private Long id;

    private String name;

    private String slug;

    public static GenreDTO dtoMapper(Genre entity) {
        return new GenreDTO(
                entity.getId(),
                entity.getName(),
                entity.getSlug());
    }
}
