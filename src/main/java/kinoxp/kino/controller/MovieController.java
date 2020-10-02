package kinoxp.kino.controller;

import kinoxp.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import main.java.kinoxp.kino.model.Movie;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movieList")
    public String displayAllMovies(Model model) {
        List<Movie> movies = movieService.fetchAll();

        model.addAttribute("movies", movies);

        return "MovieList.html";
    }




}
