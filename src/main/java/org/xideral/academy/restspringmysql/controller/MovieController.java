package org.xideral.academy.restspringmysql.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xideral.academy.restspringmysql.entity.Movie;
import org.xideral.academy.restspringmysql.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll() {
        return  movieService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Integer id) {
        return movieService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        Movie created = movieService.crearMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable Integer id, @RequestBody Movie movie) {
        return movieService.actualizarMovie(id, movie).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if(movieService.eliminarMovie(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
