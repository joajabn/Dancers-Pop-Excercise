package pl.paniodprogramowania.findBugsProject.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.ErrorResponse;
import pl.paniodprogramowania.findBugsProject.exceptions.DancerNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DancerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDancerNotFoundException(DancerNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage()));
    }
}
