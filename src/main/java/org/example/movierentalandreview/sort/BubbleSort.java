package org.example.movierentalandreview.sort;


import org.example.movierentalandreview.model.Movie;

public class BubbleSort {

    public static void sortMoviesByRating(Movie[] movies) {
        int n = movies.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (movies[j].getRating() < movies[j+1].getRating()) {
                    // swap movies[j+1] and movies[j]
                    Movie temp = movies[j];
                    movies[j] = movies[j+1];
                    movies[j+1] = temp;
                }
            }
        }
    }
}

