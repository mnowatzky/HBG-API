package de.diehbg.api;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(Long id) {
        super("Could not find sticker with id " + id);
    }
}

