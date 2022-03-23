package az.phober.device.dto;

import az.phober.device.entity.Device;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DeviceDTO {
    private Long id;

    private String name;

    private String slug;

    private String description;

    public static DeviceDTO dtoMapper(Device entity) {
        return new DeviceDTO(
                entity.getId(),
                entity.getName(),
                entity.getSlug(),
                entity.getDescription());
    }
}
