package com.example.peliculabd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.peliculabd.model.Peliculabd;

public interface PeliculaRepository extends JpaRepository<Peliculabd, Long> {
    
}
