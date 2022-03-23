package az.phober.media;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findAllByModelTypeAndModelId(String modelType, Long modelId);
    List<Media> findAllByModelTypeAndModelIdIn(String modelType, List<Long> modelIds);
}
