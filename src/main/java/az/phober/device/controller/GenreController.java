package az.phober.device.controller;

import az.phober.device.dto.GenreDTO;
import az.phober.device.exception.ResourceNotFoundException;
import az.phober.device.repository.GenreRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Genres")
@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreRepository repository;

    public GenreController(GenreRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<GenreDTO> list = repository.findAll(pageable).map(GenreDTO::dtoMapper);

        return ResponseEntity.ok(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        GenreDTO dto = repository.findById(id).map(GenreDTO::dtoMapper).orElseThrow(ResourceNotFoundException::new);

        return ResponseEntity.ok(dto);
    }
}
