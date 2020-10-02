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

    public Boolean deleteMovie(String movieId) {
        String sql = "DELETE FROM vehicle WHERE reg_number = ?";
        return template.update(sql, movieId) < 0;
    }

    public Movie addMovie(Movie m) {
        String sql = "INSERT INTO movies (movie_id, title, description, duration, age_limit, genres_id) VALUES (?, ?, ?, ?, ?, ?)";
        template.update(sql, m.getMovieId(), m.getTitle(), m.getDescription(), m.getDuration(), m.getAge_limit(), m.getGenres_id());
        return null;
    }

    /*String sql="INSERT INTO person (id, first_name, last_name) VALUES (?, ?, ?)";
         template.update(sql, p.getId(), p.getFirst_name(), p.getLast_name());
        return null;*/


    public List<Movie> fetchAll(){
        String sql = "SELECT * " +
                "FROM kino.Movies"; //ask for confirmation
        RowMapper<Movie> rowMapper= new BeanPropertyRowMapper<>(Movie.class);
        return template.query(sql,rowMapper);
    }


}
