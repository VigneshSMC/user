package com.davincicell.user.exHandler;

import com.davincicell.user.exception.UserExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestControllerAdvice
public class GlobalHandler {
    Logger logger = LoggerFactory.getLogger(GlobalHandler.class);
    @ExceptionHandler
    public ResponseEntity<String> UserNotFound(UserExistsException exception) {
        logger.info(exception.getLocalizedMessage());
        return new ResponseEntity<String>(exception.getMessage(), NOT_ACCEPTABLE);
    }
}
