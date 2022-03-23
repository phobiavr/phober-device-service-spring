package az.phober.device.controller;

import az.phober.device.dto.GameDTO;
import az.phober.device.entity.Game;
import az.phober.device.exception.ResourceNotFoundException;
import az.phober.device.repository.GameRepository;
import az.phober.media.Media;
import az.phober.media.MediaDTO;
import az.phober.media.MediaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Games")
@RestController
public class GameController {
    private final GameRepository repository;
    private final MediaRepository mediaRepository;

    public GameController(GameRepository repository, MediaRepository mediaRepository) {
        this.repository = repository;
        this.mediaRepository = mediaRepository;
    }

    @GetMapping("/games")
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<GameDTO> list = repository.findAll(pageable).map(GameDTO::dtoMapper);

        List<Media> mediaList = mediaRepository.findAllByModelTypeAndModelIdIn(Game.MODEL_TYPE, list.map(GameDTO::getId).toList());

        list.map(dto -> {
            dto.setMedia(mediaList.stream().
                    filter(media -> media.getModelId().equals(dto.getId()))
                    .map(MediaDTO::dtoMapper)
                    .collect(Collectors.toList())
            );

            return dto;
        });

        return ResponseEntity.ok(list);
    }


    @GetMapping("/games/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        GameDTO dto = repository.findById(id).map(GameDTO::dtoMapper).orElseThrow(ResourceNotFoundException::new);

        List<Media> mediaDTOList = mediaRepository.findAllByModelTypeAndModelId(Game.MODEL_TYPE, dto.getId());

        dto.setMedia(mediaDTOList.stream().map(MediaDTO::dtoMapper).collect(Collectors.toList()));

        return ResponseEntity.ok(dto);
    }
}
