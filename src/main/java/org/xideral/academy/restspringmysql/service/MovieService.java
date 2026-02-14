package org.xideral.academy.restspringmysql.service;

import org.springframework.stereotype.Service;
import org.xideral.academy.restspringmysql.entity.Movie;
import org.xideral.academy.restspringmysql.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> listarTodos() {
        return movieRepository.findAll();
    }

    public Optional<Movie> buscarPorId(Integer id) {
        return movieRepository.findById(id);
    }

    public Movie crearMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> actualizarMovie(Integer id, Movie movie) {
        return movieRepository.findById(id).map(m -> {
            m.setTitle(movie.getTitle());
            m.setDate(movie.getDate());
            m.setDuration(movie.getDuration());
            m.setClassification(movie.getClassification());
            m.setSynopsis(movie.getSynopsis());
            return movieRepository.save(m);
        });
    }

    public boolean eliminarMovie(Integer id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
