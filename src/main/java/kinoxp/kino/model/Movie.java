package kinoxp.kino.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

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
    private Date duration;
    private int ageLimit;


    public Movie() {
    }

    public Movie(int movieId, String title, String description, String genre, int year, double rating, ArrayList<Schedule> schedules, Date duration, int ageLimit) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.schedules = schedules;
        this.duration = duration;
        this.ageLimit = ageLimit;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", schedules=" + schedules +
                ", duration=" + duration +
                ", ageLimit=" + ageLimit +
                '}';
    }
}
