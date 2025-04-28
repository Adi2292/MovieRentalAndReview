package org.example.movierentalandreview.stack;


import org.example.movierentalandreview.model.Movie;
import java.util.Stack;

public class MovieStack {
    private Stack<Movie> recentlyWatched = new Stack<>();

    public void watchMovie(Movie movie) {
        recentlyWatched.push(movie);
    }

    public Movie lastWatched() {
        return recentlyWatched.isEmpty() ? null : recentlyWatched.peek();
    }

    public Stack<Movie> getAllRecentlyWatched() {
        return recentlyWatched;
    }
}

