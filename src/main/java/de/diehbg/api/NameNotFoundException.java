package de.diehbg.api;

public class NameNotFoundException extends RuntimeException {
    public NameNotFoundException(String name) {
        super("Could not find any stickers with name " + name);
    }
}
