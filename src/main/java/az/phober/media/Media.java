package az.phober.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "media")
public class Media {
    public static String URl_PREFIX = "https://phober-media-bucket.s3.amazonaws.com/";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_id")
    private Long modelId;

    @Column(name = "model_type")
    private String modelType;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "collection_name")
    private String collectionName;

    @Column(name = "disk")
    private String disk;
}
