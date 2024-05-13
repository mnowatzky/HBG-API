package de.diehbg.api;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "stickers")
public class Sticker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Point coords;
    private String name;
    //@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime loggedAt;
    private String city;
    private String state;
    private String country;

    Sticker(Point coords, String name, LocalDateTime loggedAt, String city, String state, String country) {
        this.coords = coords;
        this.name = name;
        this.loggedAt = loggedAt;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Sticker() {}

    public Point getCoords() {
        return coords;
    }

    public void setCoords(Point location) {
        this.coords = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sticker sticker = (Sticker) o;
        return getId().equals(sticker.getId()) && getCoords().equals(sticker.getCoords()) && getName().equals(sticker.getName()) && getLoggedAt().equals(sticker.getLoggedAt()) && Objects.equals(getCity(), sticker.getCity()) && Objects.equals(getState(), sticker.getState()) && Objects.equals(getCountry(), sticker.getCountry());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCoords().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getLoggedAt().hashCode();
        result = 31 * result + Objects.hashCode(getCity());
        result = 31 * result + Objects.hashCode(getState());
        result = 31 * result + Objects.hashCode(getCountry());
        return result;
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "id=" + id +
                ", location=" + coords +
                ", name='" + name + '\'' +
                ", loggedAt=" + loggedAt +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
