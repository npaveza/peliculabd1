package com.example.peliculabd.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.peliculabd.model.Peliculabd;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaRepositoryTest {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Test
    public void guardaPeliculaTest(){
        Peliculabd peliculabd = new Peliculabd();
        peliculabd.setTitulo("Titulo PruebaRepository");
        peliculabd.setAnio("2021 PruebaRepository");
        peliculabd.setDirector("Director PruebaRepository");
        peliculabd.setGenero("Genero PruebaRepository");
        peliculabd.setSinopsis("Sinopsis PruebaRepository");

        Peliculabd resultado = peliculaRepository.save(peliculabd);

        assertNotNull(resultado.getId());
        assertNotNull(resultado.getTitulo());
        assertEquals("2021", resultado.getAnio());
        assertNotNull(resultado.getDirector());
        assertNotNull(resultado.getGenero());
        assertEquals("John Doe", resultado.getSinopsis());
    }
}
