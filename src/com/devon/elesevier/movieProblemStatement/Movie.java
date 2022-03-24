package com.devon.elesevier.movieProblemStatement;

import java.util.Date;
import java.util.Objects;

public class Movie implements Comparable<Movie>{
    private String movieName;
    private Date movieDate;
    private double movieRating;


    public Movie(String movieName, Date movieDate, double movieRating) {
        this.movieName = movieName;
        this.movieDate = movieDate;
        this.movieRating = movieRating;
    }

    public String getMovieName() {
        return movieName;
    }

    public Date getMovieDate() {
        return movieDate;
    }

    public double getMovieRating() {
        return movieRating;
    }


    @Override
    public int compareTo(Movie m) {
        return this.movieName.compareTo(m.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovieName(), getMovieDate(), getMovieRating());
    }

    @Override
    public String toString() {
        return this.movieName + " " +this.movieDate + " " + this.movieRating;
    }
}
