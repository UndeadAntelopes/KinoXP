package kinoxp.kino.controller;

import kinoxp.kino.model.Movie;
import kinoxp.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;


    @GetMapping ("/selectMovie")
    public String selectMovie() {
        return "selectMovie";
    }

    @GetMapping("/selectTime/{movie_id}")
    public String select(@PathVariable("movie_id") int id, Model model) {

        return "";
    }

    @PostMapping ("/add")
    public String add(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/movieList";
    }


}
