package pl.awsome.workshops.service.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "note")
public class Note {

    @Id
    private String id;
    private String title;
    private String message;
    private LocalDateTime createDate;
}
