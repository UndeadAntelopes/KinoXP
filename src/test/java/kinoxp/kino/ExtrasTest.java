package kinoxp.kino;

import kinoxp.kino.service.ExtrasService;
import kinoxp.kino.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ExtrasTest {
    @Autowired
    ExtrasService extraService;
    
    @Test
    void fetchCurrentMovies(){
        assertEquals(5, extraService.fetchAll().size());
        
    }
    
}
