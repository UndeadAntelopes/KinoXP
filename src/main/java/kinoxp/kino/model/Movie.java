package kinoxp.kino.model;


import java.time.Duration;
import java.util.Date;

public class Movie {


    private int movieId;
    private String name;
    private String description; //actors will be in this
    private Duration duration;
    
    public String getGenres_id() {
        return genres_id;
    }
    
    public void setGenres_id(String genres_id) {
        this.genres_id = genres_id;
    }
    
    private String genres_id;
    private int year;
    private int ageLimit;
    
    public Duration getDuration() {
        return duration;
    }
    
    public void setDuration(Duration duration) {
        this.duration = duration;
    }
    
    public int getAgeLimit() {
        return ageLimit;
    }
    
    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Movie() {
    }

    public Movie(int movieId, String name, String description, String category, int year, int ageLimit, Duration duration) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
        this.genres_id = genres_id;
        this.year = year;
        this.ageLimit = ageLimit;
        this.duration = duration;
    }




    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + genres_id + '\'' +
                ", year=" + year +
                ", ageLimit=" + ageLimit + "+" +
                '}';
    }
}
