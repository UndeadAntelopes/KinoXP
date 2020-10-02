package kinoxp.kino.controller;

import kinoxp.kino.model.Movie;
import kinoxp.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/");
    public String index (Model model){
        List<Movie> movieList = movieService.fetchAll();
        model.addAttribute("movies", movieList);
        return "home/index";

    }

    @GetMapping




}
