package com.stackroute.restAPI1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private String movieName;
    private String movieReleaseDate;
    private String movieDuration;

    public Movie() {
    }

    public Movie(String movieName, String movieReleaseDate, String movieDuration) {
        this.movieName = movieName;
        this.movieReleaseDate = movieReleaseDate;
        this.movieDuration = movieDuration;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", movieReleaseDate='" + movieReleaseDate + '\'' +
                ", movieDuration='" + movieDuration + '\'' +
                '}';
    }
}
