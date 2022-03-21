package com.devon.elesevier.movieProblemStatement;

import java.util.Comparator;

public class SortByMovieRating implements Comparator<Movie> {
    public int compare(Movie a, Movie b){
        double rating1 = a.getMovieRating();
        double rating2 = b.getMovieRating();

        if(rating1>rating2){
            return -1;
        } else if(rating1<rating2){
            return 1;
        } else
            return 0;
    }
}
