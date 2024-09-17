package com.example.peliculabd.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.peliculabd.model.Peliculabd;
import com.example.peliculabd.service.PeliculabdService;


@RestController
@RequestMapping("/peliculas")
public class PeliculabdController {
    private static final Logger log = LoggerFactory.getLogger(PeliculabdController.class);
    @Autowired
    private PeliculabdService peliculabdService;
    
    @GetMapping
    public CollectionModel<EntityModel<Peliculabd>> getAllPeliculabds() {
        List<Peliculabd> peliculabds = peliculabdService.getAllPeliculabds();
        log.info("GET /peliculas");
        log.info("Retornando todas las películas");
                List<EntityModel<Peliculabd>> peliculabdResources = peliculabds.stream()
            .map(peliculabd -> EntityModel.of(peliculabd,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculabdById(peliculabd.getId())).withSelfRel()
            ))
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculabds());
        CollectionModel<EntityModel<Peliculabd>> resources = CollectionModel.of(peliculabdResources, linkTo.withRel("peliculas"));

        return resources;
    }


    @GetMapping("/{id}")
    public EntityModel<Peliculabd> getPeliculabdById(@PathVariable Long id) {
        Optional<Peliculabd> peliculabd = peliculabdService.getPeliculabdById(id);
        if (peliculabd.isPresent()) {
            return EntityModel.of(peliculabd.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculabdById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculabds()).withRel("Todoas-las-peliculas"));
        } else {
            throw new PeliculabdNotFoundException("Pelicula no encontrada con id: " + id);
        }
    }

    @PostMapping
    public EntityModel<Peliculabd> createPelicula(@Validated @RequestBody Peliculabd peliculabd) {
        Peliculabd createPelicula = peliculabdService.createPelicula(peliculabd);
            return EntityModel.of(createPelicula,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculabdById(createPelicula.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculabds()).withRel("Todoas-las-peliculas"));

    }

    @PutMapping("/{id}")
    public EntityModel<Peliculabd> updatePelicula(@PathVariable Long id, @RequestBody Peliculabd peliculabd) {
        Peliculabd updatePelicula = peliculabdService.updatePelicula(id, peliculabd);
        return EntityModel.of(updatePelicula,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculabdById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculabds()).withRel("Todoas-las-peliculas"));

    }

    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id){
        peliculabdService.deletePelicula(id);
    }

    static class ErrorResponse {
        private final String message;
    
        public ErrorResponse(String message) {
            this.message = message;
        }
    
        public String getMessage() {
            return message;
        }
    }

}
