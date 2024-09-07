package com.example.peliculabd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.peliculabd.model.Peliculabd;
import com.example.peliculabd.service.PeliculabdService;


@RestController
@RequestMapping("/peliculas")
public class PeliculabdController {
    @Autowired
    private PeliculabdService peliculabdService;
    
    @GetMapping
    public List<Peliculabd> getAllPeliculasbds() {
        return peliculabdService.getAllPeliculabds();
    }

    @GetMapping("/{id}")
    public Optional<Peliculabd> getPeliculabdById(@PathVariable Long id) {
        return peliculabdService.getPeliculabdById(id);
    }
    
}
