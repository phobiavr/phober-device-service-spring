package az.phober.device.controller;

import az.phober.device.dto.DeviceDTO;
import az.phober.device.exception.ResourceNotFoundException;
import az.phober.device.repository.DeviceRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Devices")
@RestController
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceRepository repository;

    public DeviceController(DeviceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<DeviceDTO> list = repository.findAll(pageable).map(DeviceDTO::dtoMapper);

        return ResponseEntity.ok(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        DeviceDTO dto = repository.findById(id).map(DeviceDTO::dtoMapper).orElseThrow(ResourceNotFoundException::new);

        return ResponseEntity.ok(dto);
    }
}
