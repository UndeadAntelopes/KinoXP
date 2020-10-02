package kinoxp.kino.controller;

import kinoxp.kino.model.Movie;
import kinoxp.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movie");
    public String index (Model model){
        List<Movie> movieList = movieService.fetchAll();
        model.addAttribute("movies", movieList);
        return "home/index";

    }







}
