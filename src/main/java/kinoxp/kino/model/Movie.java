package main.java.kinoxp.kino.model;

import kinoxp.kino.model.Schedule;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Movie {
    @Id
    private int movieId;
    private String title;
    private String description; //actors will be in this
    private String genre;
    private int year;
    private double rating;
    private ArrayList<Schedule> schedules;

    public Movie() {
    }

    public Movie(int movieId, String title, String description, String genre, int year, double rating, ArrayList<Schedule> schedules) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.schedules = schedules;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String category) {
        this.genre = category;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + genre + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", schedules=" + schedules +
                '}';
    }
}
