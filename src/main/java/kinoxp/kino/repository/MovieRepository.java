package kinoxp.kino.repository;

import kinoxp.kino.model.Movie;
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
        String sql = "DELETE FROM kinoxp WHERE movieId = ?";
        return template.update(sql, movieId) < 0;
    }
    
    public Movie updateMovie(Movie movie) {
        String sql = "UPDATE movies SET movie_id = ?, title = ?, description = ?, duration = ?, age_limit = ?, genres_id = ?, WHERE movie_id = ?";
        template.update(sql, movie.getMovieId(), movie.getName(), movie.getDuration(), movie.getAgeLimit(), movie.getGenres_id());
        return null;
    }


    public List<Movie> fetchAll(){
        String sql = "SELECT * " +
                "FROM kino.Movies"; //ask for confirmation
        RowMapper<Movie> rowMapper= new BeanPropertyRowMapper<>(Movie.class);
        return template.query(sql,rowMapper);
    }


}
