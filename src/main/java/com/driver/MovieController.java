package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    // 1. Add a movie: POST /movies/add-movie
    // Pass the Movie object as request body
    // Return success message wrapped in a ResponseEntity object
    // Controller Name - addMovie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }

    // 2. Add a director: POST /movies/add-director
    // Pass the Director object as request body
    // Return success message wrapped in a ResponseEntity object
    // Controller Name - addDirector
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        return new ResponseEntity<>(movieService.addDirector(director), HttpStatus.CREATED);
    }

    // 3. Pair an existing movie and director: PUT /movies/add-movie-director-pair
    // Pass movie name and director name as request parameters
    // Return success message wrapped in a ResponseEntity object
    // Controller Name - addMovieDirectorPair
    @PutMapping("add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, String director) {
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movie, director), HttpStatus.CREATED);
    }

    // 4. Get Movie by movie name: GET /movies/get-movie-by-name/{name}
    // Pass movie name as path parameter
    // Return Movie object wrapped in a ResponseEntity object
    // Controller Name - getMovieByName
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
        return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.CREATED);
    }

    // 5. Get Director by director name: GET /movies/get-director-by-name/{name}
    // Pass director name as path parameter
    // Return Director object wrapped in a ResponseEntity object
    // Controller Name - getDirectorByName
    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name) {
        return new ResponseEntity<>(movieService.getDirectorByName(name), HttpStatus.CREATED);
    }

    // 6. Get List of movies name for a given director name: GET
    // /movies/get-movies-by-director-name/{director}
    // Pass director name as path parameter
    // Return List of movies name(List()) wrapped in a ResponseEntity object
    // Controller Name - getMoviesByDirectorName
    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director) {
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director), HttpStatus.CREATED);
    }

    // 7. Get List of all movies added: GET /movies/get-all-movies
    // No params or body required
    // Return List of movies name(List()) wrapped in a ResponseEntity object
    // Controller Name - findAllMovies
    @GetMapping("get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.CREATED);
    }

    // 8. Delete a director and its movies from the records: DELETE
    // /movies/delete-director-by-name
    // Pass director’s name as request parameter
    // Return success message wrapped in a ResponseEntity object
    // Controller Name - deleteDirectorByName
    @DeleteMapping("delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director) {
        return new ResponseEntity<>(movieService.deleteDirectorByName(director), HttpStatus.CREATED);
    }

    // 9. Delete all directors and all movies by them from the records: DELETE
    // /movies/delete-all-directors
    // No params or body required
    // Return success message wrapped in a ResponseEntity object
    // Controller Name - deleteAllDirectors
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.CREATED);
    }

}
