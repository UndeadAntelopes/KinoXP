package kinoxp.kino.model;

import kinoxp.kino.model.Schedule;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    private int movieId;
    private String title;
    private String description; //actors will be in this

    private String genre;
    private int year;
    private double rating;
    private String start;
    private String end;
    private String ageLimit;


    public Movie() {
    }

    public Movie(int movieId, String title, String description, String genre, int year, double rating, String start, String end, String ageLimit) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;

        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.start = start;
        this.end = end;
        this.ageLimit = ageLimit;
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


    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getStart() {return this.start;}

    public void setStart(String start) {this.start = start;}

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
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
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
