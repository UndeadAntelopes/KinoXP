package kinoxp.kino;

import kinoxp.kino.model.Movie;
import kinoxp.kino.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
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

    //Test if dateTime scheduling works
    @Test
    void currentSchedules() {
        assertEquals("2020-10-15 10:00:00", movieService.currentSchedule().get(0).getStart());
    }

    //See if the sorting actually sorts via genre
    @Test
    void sortedMovies(){

        List<String> actual = Arrays.asList("Action", "Comedy", "Erotic", "Romance Comedy", "Sci-Fi");
        List<Movie> expected = movieService.sortByGenre((ArrayList<Movie>) movieService.fetchCurrentMovies());
        List<String> list = new ArrayList<>();

        for (Movie movie:expected){
            list.add(movie.getGenre());
            System.out.println(movie.getGenre());
        }

        //1. Test equal.
        assertEquals(actual, list);

    }

}
