package kinoxp.kino.repository;

import kinoxp.kino.model.Extras;
import kinoxp.kino.model.Movie;
import kinoxp.kino.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExtrasRepository {
    
    @Autowired
    JdbcTemplate template;
    
    public Boolean deleteExtras(int id) {
        String sql = "DELETE FROM extras WHERE id = ?";
        return template.update(sql, id) < 0;
    }
    
    public Extras addExtras(Extras e) {
        String sql = "INSERT INTO extras (name, price, stock) VALUES (?, ?, ?)";
        template.update(sql, e.getName(), e.getPrice(), e.getStock());
        return null;
    }
    
    public Movie updateExtras(Extras extras) {
        String sql = "UPDATE extras SET name = ?, price = ?, stock = ? WHERE id = ?";
        template.update(sql, extras.getName(), extras.getPrice(), extras.getStock(), extras.getId());
        return null;
    }
    
    public List<Extras> fetchAll(){
        String sql = "SELECT * " +
                "FROM kinoxp.Extras;"; //ask for confirmation
        RowMapper<Extras> rowMapper= new BeanPropertyRowMapper<>(Extras.class);
        return template.query(sql,rowMapper);
    }
    
    public Extras findExtrasById(int id){
        String sql = "SELECT * " +
                "FROM kinoxp.Extras WHERE id = ?"; //ask for confirmation
        RowMapper<Extras> rowMapper= new BeanPropertyRowMapper<>(Extras.class);
        return template.queryForObject(sql, rowMapper, id);
    }
    
}
