package com.example.peliculabd.service;

import java.util.List;
import java.util.Optional;

import com.example.peliculabd.model.Peliculabd;

public interface PeliculabdService {
    List<Peliculabd> getAllPeliculabds();
    Optional<Peliculabd> getPeliculabdById(Long id);
}
