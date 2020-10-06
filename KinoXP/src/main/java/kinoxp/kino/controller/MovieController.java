package kinoxp.kino.controller;

import kinoxp.kino.model.Movie;
import kinoxp.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping ("/add")
    public String add() {
        return "/home/add";
    }

    @PostMapping ("/add")
    public String add(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/";
    }








}
