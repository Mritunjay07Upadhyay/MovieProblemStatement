package com.devon.elesevier.movieProblemStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieMain {
    public static void main(String[] args) {
        System.out.println("Welcome! To the movie review");
        Scanner scanner = new Scanner(System.in);
        HashSet<Movie> mainMovieSet  = new HashSet<>();
        boolean movieQuestion;
        while(true){
            System.out.println("Do you want to enter movie rating yes or no? ");
            String inputString = scanner.nextLine();
            movieQuestion =inputString.equalsIgnoreCase("Yes");
            if(!movieQuestion){
                System.out.println("Come again Later!");
                break;
            }

            System.out.println("Enter the name of the movie: ");
            String movieName = scanner.nextLine();
            System.out.println("Enter the movie rating(out of 10):");
            double rating = scanner.nextDouble();
            scanner.next();
            Date movieDate = null;
            while( movieDate == null ) {
                try {
                    System.out.println("Enter the release date(dd-mm-yyyy)");
                    String inputDate = scanner.nextLine();
                    movieDate = new SimpleDateFormat("dd-MM-yyyy").parse(inputDate);
                } catch (ParseException e){
                    System.out.println("You've entered the wrong date format");
                }
            }
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
