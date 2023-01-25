package com.driver;

import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
    HashMap<String, List<String>> pairDb = new HashMap<>();

    public String addMovie(Movie movie) {
        movieDb.put(movie.getName(), movie);
        return "Added Successfully";
    }

    public String addDirector(Director director) {
        directorDb.put(director.getName(), director);
        return "Added Successfully";
    }

    public String addMovieDirectorPair(String movie, String director) {
        List<String> list = pairDb.getOrDefault(director, new ArrayList<>());
        list.add(movie);
        pairDb.put(director, list);
        return "Added Successfully";
    }

    public Movie getMovieByName(String movie) {
        for (Movie m : movieDb.values()) {
            if (m.getName().equals(movie)) {
                return m;
            }
        }
        return null;
    }

    public Director getDirectorByName(String director) {
        for (Director d : directorDb.values()) {
            if (d.getName().equals(director)) {
                return d;
            }
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String director) {
        if (pairDb.containsKey(director)) {
            return pairDb.get(director);
        }
        return null;
    }

    public List<String> findAllMovies() {
        List<String> list = new ArrayList<>();
        for (Movie m : movieDb.values()) {
            list.add(m.getName());
        }
        return list;
    }

    public String deleteDirectorByName(String director) {
        if (pairDb.containsKey(director)) {
            List<String> list = pairDb.get(director);
            for (String s : list) {
                if (movieDb.containsKey(s)) {
                    movieDb.remove(s);
                }
            }
            pairDb.remove(director);
        }

        if (directorDb.containsKey(director)) {
            directorDb.remove(director);
        }
        return "Deleted Successfully";
    }

    public String deleteAllDirectors() {
        for (String d : directorDb.keySet()) {
            if (pairDb.containsKey(d)) {
                List<String> list = pairDb.get(d);
                for (String s : list) {
                    if (movieDb.containsKey(s)) {
                        movieDb.remove(s);
                    }
                }
            }
        }
        pairDb.clear();
        directorDb.clear();
        return "Deleted Successfully";
    }

}
