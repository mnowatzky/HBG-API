package de.diehbg.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class StickerNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String stickerNotFoundHandler(IdNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String stickerNotFoundHandler(NameNotFoundException ex) {
        return ex.getMessage();
    }

}
