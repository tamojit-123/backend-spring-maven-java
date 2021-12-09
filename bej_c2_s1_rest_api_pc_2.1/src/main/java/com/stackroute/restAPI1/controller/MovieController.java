package com.stackroute.restAPI1.controller;

import com.stackroute.restAPI1.model.Movie;
import com.stackroute.restAPI1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @PostMapping("/movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }
    @GetMapping("/movies")
    public ResponseEntity<?> getAllMovie(){
        return  new ResponseEntity<>(movieService.getAllMovie(),HttpStatus.OK);
    }
    @GetMapping("/movie/{movieName}")
    public ResponseEntity<?> findByMovieName(@PathVariable("movieName") String movieName){
        return new ResponseEntity<>(movieService.findByMovieName(movieName),HttpStatus.OK);
    }
    @PutMapping("/movie/{movieId}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie,@PathVariable("movieId") String movieId){
        return new ResponseEntity<>(movieService.updateMovie(movie,movieId),HttpStatus.OK);
    }
    @DeleteMapping("/movie/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable("movieId") String movieId){
        return new ResponseEntity<>(movieService.deleteMovie(movieId),HttpStatus.OK);
    }
}
