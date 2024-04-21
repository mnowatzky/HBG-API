package de.diehbg.api;

public class StickerNotFoundException extends RuntimeException {
    public StickerNotFoundException(Long id) {
        super("Could not find sticker with id " + id);
    }
}
