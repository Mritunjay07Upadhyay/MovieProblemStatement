package com.devon.elesevier.movieProblemStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieMain {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome! To the movie review");
        scanner = new Scanner(System.in);
        Set<Movie> mainMovieSet = new HashSet<>();
        boolean movieQuestion;
        while (true) {
            System.out.println("Do you want to enter movie details yes or no? ");
            String inputString = scanner.next();
            movieQuestion = inputString.equalsIgnoreCase("Yes");
            if (!movieQuestion) {
                System.out.println("Head towards sorting!");
                break;
            }


            System.out.println("Enter the name of the movie: ");
            String movieName = scanner.next();

            double rating=0.0d;
            while(rating==0) {
                try {
                    System.out.println("Enter the movie rating(out of 10):");
                    String rate = scanner.next();
                    rating = Double.parseDouble(rate);
                } catch (NumberFormatException n) {
                    System.out.println("enter again");
                }
            }

            Date movieDate = null;
            while (movieDate == null) {
                try {
                    System.out.println("Enter the release date(dd-mm-yyyy)");
                    String inputDate = scanner.next();
                    movieDate = new SimpleDateFormat("dd-MM-yyyy").parse(inputDate);
                } catch (ParseException e) {
                    System.out.println("You've entered the wrong date format");
                }
            }
            Movie movie = new Movie(movieName, movieDate, rating);
            mainMovieSet.add(movie);

        }
       // Set<Movie> movieTreeSet = new TreeSet<>(mainMovieSet);
        List<Movie> list = new ArrayList<>(mainMovieSet);
        boolean sortQuestion;
        while (true) {
            try {
                System.out.println("Do you want sort the movies entered? Yes or No");
                String inputString = scanner.next();
                sortQuestion = inputString.equalsIgnoreCase("Yes");
                if (!sortQuestion) {
                    System.out.println("Come again Later!");
                    break;
                }
                System.out.println("Enter the Sorting you want to see");
                System.out.println("Enter 1.unsorted 2.movie title 3.movie rating ");
                String ch = scanner.next();
                int choice = Integer.parseInt(ch);
                switch (choice){
                    case 1: System.out.println("***********Movie UnSorted Movies***************");
                        System.out.println("Before Sorting the movie by name: ");
                        for (Movie m :
                                mainMovieSet) {
                            System.out.println(m.getMovieName() + " " + m.getMovieDate() + " " + m.getMovieRating());
                        }
                        break;
                    case 2: System.out.println("***********Movie Sorted By Titles***************");
                        System.out.println("After sorting movie by there titles: ");
                        Collections.sort(list);
                        for (Movie m :
                                list) {
                            System.out.println(m.getMovieName() + " " + " " + m.getMovieRating());
                        }
                        break;
                    case 3:System.out.println("***********Movie Sorted By Ratings***************");
                        Collections.sort(list, new SortByMovieRating());
                        System.out.println("Movie sorted by their ratings: ");
                        for (Movie m : list) {
                            System.out.println(m.getMovieName() + " " + m.getMovieDate() + " " + m.getMovieRating());
                        }
                        break;
                    default:  System.out.println("Enter again!");
                }
            } catch (NumberFormatException e){
                System.out.println("Enter the proper number choice");
            }
        }
    }
}