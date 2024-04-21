package de.diehbg.api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Sticker {
    @Id
    @GeneratedValue
    private Long id;
    private double latitude;
    private double longitude;
    private String name;
    private LocalDateTime loggedAt;
    private String city;
    private String state;
    private String country;

    Sticker() {}

    Sticker(double latitude, double longitude, String name, LocalDateTime loggedAt, String city, String state, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.loggedAt = loggedAt;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
        return Double.compare(getLatitude(), sticker.getLatitude()) == 0 && Double.compare(getLongitude(), sticker.getLongitude()) == 0 && getId().equals(sticker.getId()) && getName().equals(sticker.getName()) && getLoggedAt().equals(sticker.getLoggedAt()) && getCity().equals(sticker.getCity()) && getState().equals(sticker.getState()) && getCountry().equals(sticker.getCountry());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + Double.hashCode(getLatitude());
        result = 31 * result + Double.hashCode(getLongitude());
        result = 31 * result + getName().hashCode();
        result = 31 * result + getLoggedAt().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getState().hashCode();
        result = 31 * result + getCountry().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                ", loggedAt=" + loggedAt +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
