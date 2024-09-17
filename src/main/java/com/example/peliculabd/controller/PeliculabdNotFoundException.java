package com.example.peliculabd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PeliculabdNotFoundException extends RuntimeException {
    public PeliculabdNotFoundException(String message) {
        super(message);
    }
}
