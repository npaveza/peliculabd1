package com.example.peliculabd.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.peliculabd.model.Peliculabd;
import com.example.peliculabd.repository.PeliculaRepository;

@ExtendWith(MockitoExtension.class)
public class PeliculabdServiceTest {
    @InjectMocks
    private PeliculabdServiceImpl peliculabdService;

    @Mock
    private PeliculaRepository peliculabdRepositoryMock;

    @Test
    public void guardaPeliculaTest(){
        Peliculabd peliculabd = new Peliculabd();
        peliculabd.setTitulo("Titulo Prueba");
        peliculabd.setAnio("2022");
        peliculabd.setDirector("Director Prueba");
        peliculabd.setGenero("Genero Prueba");
        peliculabd.setSinopsis("Sinopsis Prueba");


        when(peliculabdRepositoryMock.save(any())).thenReturn(peliculabd);

        Peliculabd resultado = peliculabdService.createPelicula(peliculabd);

        assertEquals("Titulo Prueba", resultado.getTitulo());
        assertEquals("2022", resultado.getAnio());
        assertEquals("Director Prueba", resultado.getDirector());
        assertEquals("Genero Prueba", resultado.getGenero());
        assertEquals("Sinopsis Prueba", resultado.getSinopsis());
    }
}
