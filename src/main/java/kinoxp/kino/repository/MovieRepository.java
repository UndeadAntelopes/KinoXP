package kinoxp.kino.repository;

import kinoxp.kino.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import main.java.kinoxp.kino.model.Movie;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate template;

    public Boolean deleteMovie(String movieId) {
        String sql = "DELETE FROM vehicle WHERE reg_number = ?";
        return template.update(sql, movieId) < 0;
    }
    /*
    public Movie updateMovie(Movie movie) {
        String sql = "UPDATE vehicle SET movieId = ?, name = ?, description = ?, year = ?, cat_id = ?, WHERE reg_number = ?";
        template.update(sql, movie.getRegNumber(), vehicle.getCatId(), vehicle.getYearStmp(), vehicle.getOdometer(), vehicle.getTransmission(), vehicle.getFuelType(), vehicle.isOperational(), vehicle.getoComment(), vehicle.getRegNumber());
        return null;
    }
    */

    public List<Movie> fetchAll(){
        String sql = "SELECT * " +
                "FROM kino.Movies;"; //ask for confirmation
        RowMapper<Movie> rowMapper= new BeanPropertyRowMapper<>(Movie.class);
        return template.query(sql,rowMapper);
    }

    public List<Schedule> fetchSchedule() {
        String query = "SELECT * FROM kinoxp.schedule;";
        RowMapper<Schedule> rowMapper = new BeanPropertyRowMapper<>(Schedule.class);

        return template.query(query, rowMapper);
    }

}
