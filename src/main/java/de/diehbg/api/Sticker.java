package de.diehbg.api;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
@Entity
@Table(name = "stickers")
public class Sticker {
    @Id
    @Null(message = "cannot include id for new entity")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Point coords;
    private String name;
    private LocalDateTime loggedAt;
    private String city;
    private String state;
    private String country;
}
