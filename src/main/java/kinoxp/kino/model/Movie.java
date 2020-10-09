package kinoxp.kino.model;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Date duration;
    private int ageLimit;
    private String start;
    private String end;


    public Movie() {
    }

    public Movie(int movieId, String title, String description, String genre, int year, double rating, Date duration, int ageLimit, String start, String end) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
        this.ageLimit = ageLimit;
        this.start = start;
        this.end = end;
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

    public void setTitle(String title) {
        this.title = title;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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
                ", duration=" + duration +
                ", ageLimit='" + ageLimit + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
