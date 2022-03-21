package com.devon.elesevier.movieProblemStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieMain {
    public static void main(String[] args) throws ParseException {
        System.out.println("Welcome! To the movie review");
        Scanner scanner = new Scanner(System.in);
        Set<Movie> mainMovieSet  = new HashSet<>();

        System.out.println("How many movies ratings do you want to enter? ");
        int movieCount = scanner.nextInt();
        for (int i = 0; i<movieCount;i++) {
            System.out.println("Enter the name of the movie: ");
            String movieName = scanner.next();
            System.out.println("Enter the movie rating(out of 10):");
            double rating = scanner.nextDouble();
            System.out.println("Enter the release date(dd-mm-yyyy)");
            String inputDate = scanner.next();
            Date movieDate=new SimpleDateFormat("dd-MM-yyyy").parse(inputDate);
            Movie movie = new Movie(movieName,movieDate,rating);
            mainMovieSet.add(movie);
        }
        System.out.println("***********Movie UnSorted Movies***************");
        System.out.println("Before Sorting the movie by name: ");
        for (Movie m:
             mainMovieSet) {
            System.out.println(m.getMovieName()+" "+m.getMovieDate()+" "+m.getMovieRating());
        }
        TreeSet<Movie> movieTreeSet = new TreeSet<>(mainMovieSet);
        System.out.println("***********Movie Sorted By Titles***************");
        System.out.println("After sorting movie by there titles: ");
        for (Movie m:
             movieTreeSet) {
            System.out.println(m.getMovieName()+" "+m.getMovieDate()+" "+m.getMovieRating());
        }
        System.out.println("***********Movie Sorted By Ratings***************");
        List<Movie> list = new ArrayList<>(mainMovieSet);
        Collections.sort(list,new SortByMovieRating());
        System.out.println("Movie sorted by their ratings: ");
        for(Movie m: list){
            System.out.println(m.getMovieName()+" "+m.getMovieDate()+" "+m.getMovieRating());
        }

    }
}
