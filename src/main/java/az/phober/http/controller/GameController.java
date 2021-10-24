package az.phober.http.controller;

import az.phober.entity.Game;
import az.phober.http.dto.GameDTO;
import az.phober.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GameController {
    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    public static GameDTO entityToDTO(Game entity){
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
    public ResponseEntity<?> getAll() {
        List<GameDTO> list = service.getAll().stream().map(GameController::entityToDTO).collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }
}
