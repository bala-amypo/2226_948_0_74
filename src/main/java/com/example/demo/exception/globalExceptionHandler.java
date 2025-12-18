package com.example.demo.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleFieldError(
            MethodArgumentNotValidException ex) {

        Map<String, String> error = new HashMap<>();

        ex.getBindingResult()
          .getFieldErrors()
          .forEach(err ->
              error.put(err.getField(), err.getDefaultMessage())
          );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}