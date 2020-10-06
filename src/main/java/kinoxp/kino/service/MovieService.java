package kinoxp.kino.service;

import kinoxp.kino.model.Movie;
import kinoxp.kino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> fetchAll() {
        return movieRepository.fetchAll();
    }

    public void updateMovie(Movie movie) {movieRepository.updateMovie(movie);}

    public boolean deleteMovie(int id) { return movieRepository.deleteMovie(id);}


}
