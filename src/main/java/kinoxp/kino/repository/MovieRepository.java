package kinoxp.kino.repository;

import kinoxp.kino.model.Movie;
import kinoxp.kino.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate template;
    /*
    public Boolean deleteMovie(int movieId) {
        String sql = "DELETE FROM kinoxp WHERE movieId = ?";
        return template.update(sql, movieId) < 0;
    }

    public Movie updateMovie(Movie movie) {
        String sql = "UPDATE movies SET movie_id = ?, title = ?, description = ?, duration = ?, age_limit = ?, genres_id = ?, WHERE movie_id = ?";
        template.update(sql, movie.getMovieId(), movie.getName(), movie.getDuration(), movie.getAgeLimit(), movie.getGenres_id());
        return null;
    }
    */

    public List<Movie> fetchAll(){
        String sql = "SELECT * " +
                "FROM kinoxp.Movies;"; //ask for confirmation
        RowMapper<Movie> rowMapper= new BeanPropertyRowMapper<>(Movie.class);
        return template.query(sql,rowMapper);
    }

    public List<Schedule> fetchSchedule() {
        String query = "SELECT * FROM kinoxp.schedule;";
        RowMapper<Schedule> rowMapper = new BeanPropertyRowMapper<>(Schedule.class);

        return template.query(query, rowMapper);
    }

    public List<Movie> fetchCurrentMovies (String scheduleIds){
        String sql = "SELECT movie_id, title, description, duration, age_limit, genre, start, end " +
        "FROM movies " +
        "JOIN genres ON genres.genres_id = movies.genres_id " +
        "JOIN movies_has_schedule ON movies.movie_id = movies_has_schedule.movies_movie_id " +
        "JOIN schedule ON movies_has_schedule.schedule_schedule_id = schedule.schedule_id " +
        "WHERE movies_movie_id IN ( "+ scheduleIds +");";
        RowMapper<Movie> rowMapper = new BeanPropertyRowMapper<>(Movie.class);
        return template.query(sql, rowMapper);

    }

}
