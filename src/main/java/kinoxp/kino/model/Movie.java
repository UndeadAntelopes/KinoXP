package kinoxp.kino.model;


public class Movie {


    private int movieId;
    private String name;
    private String description; //actors will be in this
    private String category;
    private int year;
    private double rating;

    public Movie() {
    }

    public Movie(int movieId, String name, String description, String category, int year, double rating) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.year = year;
        this.rating = rating;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}
