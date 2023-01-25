package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        String result = movieRepository.addMovie(movie);
        return result;
    }

    public String addDirector(Director director) {
        String result = movieRepository.addDirector(director);
        return result;
    }

    public String addMovieDirectorPair(String movie, String director) {
        String result = movieRepository.addMovieDirectorPair(movie, director);
        return result;
    }

    public Movie getMovieByName(String movie) {
        Movie result = movieRepository.getMovieByName(movie);
        return result;
    }

    public Director getDirectorByName(String director) {
        Director result = movieRepository.getDirectorByName(director);
        return result;
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> result = movieRepository.getMoviesByDirectorName(director);
        return result;
    }

    public List<String> findAllMovies() {
        List<String> result = movieRepository.findAllMovies();
        return result;
    }

    public String deleteDirectorByName(String director) {
        String result = movieRepository.deleteDirectorByName(director);
        return result;
    }

    public String deleteAllDirectors() {
        String result = movieRepository.deleteAllDirectors();
        return result;
    }

}
