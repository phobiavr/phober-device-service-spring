package az.phober.http.controller;

import az.phober.entity.Game;
import az.phober.http.dto.GameDTO;
import az.phober.repository.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

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
                .orElseThrow(EntityNotFoundException::new);

        return ResponseEntity.ok(dto);
    }
}
