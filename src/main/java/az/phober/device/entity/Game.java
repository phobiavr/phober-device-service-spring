package az.phober.device.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "games")
public class Game {
    public static String VIDEO_URL_PREFIX = "https://www.youtube.com/watch?v=";

    public static String MODEL_TYPE = "App\\Models\\Game";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String slug;

    private String video;

    private String description;

    private Integer rating;

    private Boolean multiplayer;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_at")
    private Date createdAt;
}
