package org.example.movierentalandreview.model;


public class Movie {
    private String title;
    private double rating;

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
}

