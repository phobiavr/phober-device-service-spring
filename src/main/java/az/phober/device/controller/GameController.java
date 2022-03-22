package az.phober.device.controller;

import az.phober.device.dto.GameDTO;
import az.phober.device.entity.Game;
import az.phober.device.exception.ResourceNotFoundException;
import az.phober.device.repository.GameRepository;
import az.phober.media.MediaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Games")
@RestController
public class GameController {
    private final GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    public static GameDTO entityToDTO(Game entity) {
        return new GameDTO(
                entity.getId(),
                entity.getName(),
                entity.getSlug(),
                entity.getVideo(),
                entity.getDescription(),
                entity.getRating(),
                entity.getMultiplayer(),
                entity.getUpdatedAt(),
                entity.getCreatedAt());
    }

    @GetMapping("/games")
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<GameDTO> list = repository.findAll(pageable).map(GameController::entityToDTO);

        return ResponseEntity.ok(list);
    }


    @GetMapping("/games/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        GameDTO dto = repository.findById(id).map(GameController::entityToDTO)
                .orElseThrow(ResourceNotFoundException::new);

        return ResponseEntity.ok(dto);
    }
}
