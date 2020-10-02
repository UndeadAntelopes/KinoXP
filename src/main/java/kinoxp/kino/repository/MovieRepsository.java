package kinoxp.kino.repository;

import kinoxp.kino.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepsository {
    @Autowired
    JdbcTemplate template;
    
    public Boolean deleteMovie(String movieId) {
        String sql = "DELETE FROM vehicle WHERE reg_number = ?";
        return template.update(sql, movieId) < 0;
    }
    
    public Movie updateMovie(Movie movie) {
        String sql = "UPDATE vehicle SET movieId = ?, name = ?, description = ?, year = ?, cat_id = ?, WHERE reg_number = ?";
        template.update(sql, movie.getMovieId(), movie.getDescription(), movie.getYear(), movie.getCategory());
        return null;
    }
}
