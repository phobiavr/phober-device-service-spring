package az.phober.media;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MediaDTO {
    private String collectionName;

    private String url;

    public static MediaDTO dtoMapper(Media entity) {
        String url = Media.URl_PREFIX.concat(entity.getId().toString()).concat("/").concat(entity.getFileName());

        return new MediaDTO(
                entity.getCollectionName(),
                url
        );
    }
}
