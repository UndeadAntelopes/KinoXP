package kinoxp.kino;

import kinoxp.kino.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CurrentMoviesTest {
    @Autowired
    MovieService movieService;

    @Test
    void fetchCurrentMovies(){
        assertEquals(5, movieService.allSchedules().size());
        assertEquals(5, movieService.currentSchedule().size());
        assertEquals(5, movieService.fetchCurrentMovies().size());

    }

}
