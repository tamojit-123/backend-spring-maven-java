package com.niit.movieservice.service;

import com.niit.movieservice.model.Movie;

import java.util.List;

public interface MovieService {

    Movie saveMovie(Movie movie);

    List<Movie> getAllMovie();
}
