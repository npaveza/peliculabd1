package com.example.peliculabd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.peliculabd.model.Peliculabd;
import com.example.peliculabd.repository.PeliculaRepository;


@Service
public class PeliculabdServiceImpl implements PeliculabdService{
    @Autowired
    private PeliculaRepository peliculabdRepository;

    @Override
    public List<Peliculabd> getAllPeliculabds(){
        return peliculabdRepository.findAll();
    }

    @Override
    public Optional<Peliculabd> getPeliculabdById(Long id){
        return peliculabdRepository.findById(id);
    }

    
}
