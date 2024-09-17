package com.example.peliculabd.controller;
/*
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.EntityModel;
import org.springframework.test.web.servlet.MockMvc;

import com.example.peliculabd.model.Peliculabd;
import com.example.peliculabd.service.PeliculabdService;

@WebMvcTest(PeliculabdController.class)
public class PeliculabdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculabdService peliculabdServiceMock;

    @Test
    public void obtenerTodosTest() throws Exception {
        Peliculabd peliculabd1 = new Peliculabd();
        peliculabd1.setId(1L);
        peliculabd1.setTitulo("Titulo Test1");
        peliculabd1.setAnio("2021");
        peliculabd1.setDirector("Director Test1");
        peliculabd1.setGenero("Genero Test1");
        peliculabd1.setSinopsis("Sinopsis Test1");
        Peliculabd peliculabd2 = new Peliculabd();
        peliculabd1.setId(2L);
        peliculabd1.setTitulo("Titulo Test2");
        peliculabd1.setAnio("2021");
        peliculabd1.setDirector("Director Test2");
        peliculabd1.setGenero("Genero Test2");
        peliculabd1.setSinopsis("Sinopsis Test2");
        List<Peliculabd> peliculasbds = List.of(peliculabd1, peliculabd2);

        List<EntityModel<Peliculabd>> peliculabdResources = peliculasbds.stream()
            .map(peliculabd -> EntityModel.of(peliculabd))
            .collect(Collectors.toList());

        when(peliculabdServiceMock.getAllPeliculabds()).thenReturn(peliculasbds);

        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk())
                // Here, use direct JSON path matching without Matchers
                .andExpect(jsonPath("$._embedded.peliculabds.length()").value(2))
                .andExpect(jsonPath("$._embedded.peliculasbd[0].id").value(1L))
                .andExpect(jsonPath("$._embedded.peliculasbd[0].titulo").value("Titulo Test1"))
                .andExpect(jsonPath("$._embedded.peliculasbd[0].anio").value("2021"))
                .andExpect(jsonPath("$._embedded.peliculasbd[0].director").value("Director Test1"))
                .andExpect(jsonPath("$._embedded.peliculasbd[0].genero").value("Genero Test1"))
                .andExpect(jsonPath("$._embedded.peliculasbd[0].sinopsis").value("Sinopsis Test1"))
                .andExpect(jsonPath("$._embedded.peliculasbd[1].id").value(2L))
                .andExpect(jsonPath("$._embedded.peliculasbd[1].titulo").value("Titulo Test2"))
                .andExpect(jsonPath("$._embedded.peliculasbd[1].anio").value("2021"))
                .andExpect(jsonPath("$._embedded.peliculasbd[1].director").value("Director Test2"))
                .andExpect(jsonPath("$._embedded.peliculasbd[1].genero").value("Genero Test2"))
                .andExpect(jsonPath("$._embedded.peliculasbd[1].sinopsis").value("Sinopsis Test2"))
                .andExpect(jsonPath("$._embedded.peliculasbd[0]._links.self.href").value("http://localhost:8080/peliculas/1"))
                .andExpect(jsonPath("$._embedded.peliculasbd[1]._links.self.href").value("http://localhost:8080/peliculas/2"));
    }
}
 */