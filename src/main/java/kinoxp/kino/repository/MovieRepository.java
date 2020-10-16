package kinoxp.kino.repository;

import kinoxp.kino.model.Movie;
import kinoxp.kino.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate template;

    public Boolean deleteMovie(int movieId) {
        String sql = "DELETE FROM movies WHERE movie_id = ?";
        return template.update(sql, movieId) < 0;
    }

    public Movie addMovie(Movie m) {
        String sql = "INSERT INTO movies (title, description, duration, age_limit, genres_id) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, m.getTitle(), m.getDescription(), m.getDuration(), m.getAgeLimit(), m.getGenre());
        return null;
    }

    public void setSchedule(Schedule s) {
        String sql = "INSERT INTO schedule(start, end, cinema_id) VALUES (?, ?, ?)";
        template.update(sql, s.getStart(), s.getEnd(), s.getCinemaId());
    }

    public Movie updateMovie(Movie movie) {
        String sql = "UPDATE movies SET title = ?, description = ?, duration = ?, age_limit = ?, genres_id = ? WHERE movie_id = ?";
        template.update(sql, movie.getTitle(), movie.getDescription(), movie.getDuration(), movie.getAgeLimit(), movie.getGenre(), movie.getMovieId());
        return null;
    }

    public List<Movie> fetchAll(){
        String sql = "SELECT * " +
                "FROM kinoxp.Movies " +
                "JOIN genres ON genres.genres_id = movies.genres_id;"; //ask for confirmation
        RowMapper<Movie> rowMapper= new BeanPropertyRowMapper<>(Movie.class);
        return template.query(sql,rowMapper);
    }

    public List<Schedule> fetchSchedule() {
        String query = "SELECT * FROM kinoxp.schedule;";
        RowMapper<Schedule> rowMapper = new BeanPropertyRowMapper<>(Schedule.class);

        return template.query(query, rowMapper);
    }

    public List<Movie> fetchCurrentMovies (String scheduleIds){
        String sql = "SELECT movie_id, title, description, duration, age_limit, genre, start, end, cinema_id " +
        "FROM movies " +
        "JOIN genres ON genres.genres_id = movies.genres_id " +
        "JOIN movies_has_schedule ON movies.movie_id = movies_has_schedule.movies_movie_id " +
        "JOIN schedule ON movies_has_schedule.schedule_schedule_id = schedule.schedule_id ";
        if (!scheduleIds.isEmpty()) {
            sql += "WHERE schedule_schedule_id IN ( "+ scheduleIds +")";
        }
        //Incldue this for good form :)
        sql += ";";
        RowMapper<Movie> rowMapper = new BeanPropertyRowMapper<>(Movie.class);
        return template.query(sql, rowMapper);

    }

    public Movie findMovieById(int id){
        String sql = "SELECT * " +
                "FROM kinoxp.Movies WHERE movie_id = ?"; //ask for confirmation
        RowMapper<Movie> rowMapper= new BeanPropertyRowMapper<>(Movie.class);
        return template.queryForObject(sql, rowMapper, id);
    }

}
