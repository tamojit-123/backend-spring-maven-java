package com.stackroute.restAPI1.service;

import com.stackroute.restAPI1.model.Movie;

import java.util.List;

public interface MovieService {
    Movie addMovie(Movie movie);
    List<Movie> getAllMovie();
    List<Movie> findByMovieName(String movieName);
    Movie updateMovie(Movie movie,String movieId);
    boolean deleteMovie(String movieId);
}
