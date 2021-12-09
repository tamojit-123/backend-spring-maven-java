package com.stackroute.restAPI1.service;

import com.stackroute.restAPI1.model.Movie;
import com.stackroute.restAPI1.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovie() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public List<Movie> findByMovieName(String movieName) {
        return movieRepository.findByMovieName(movieName);
    }

    @Override
    public Movie updateMovie(Movie movie, String movieId) {
        if (movieRepository.findById(movieId).isEmpty()) {
            return null;
        }
        return movieRepository.save(movie);
    }

    @Override
    public boolean deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
        return true;
    }
}
