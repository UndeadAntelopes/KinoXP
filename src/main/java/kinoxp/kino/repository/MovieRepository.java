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

    public Movie updateMovie(Movie movie) {
        String sql = "UPDATE movies SET movie_id = ?, title = ?, description = ?, duration = ?, age_limit = ?, genres_id = ? WHERE movie_id = ?";
        template.update(sql, movie.getMovieId(), movie.getTitle(), movie.getDuration(), movie.getAgeLimit(), movie.getGenre());
        return null;
    }

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


}
