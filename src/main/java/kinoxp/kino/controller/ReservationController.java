package kinoxp.kino.controller;

import kinoxp.kino.model.Movie;
import kinoxp.kino.model.Schedule;
import kinoxp.kino.service.MovieService;
import kinoxp.kino.service.ReservationService;
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
    MovieService movieService;


    @GetMapping("/selectTime/{movie_id}")
    public String select(@PathVariable("movie_id") int movie_id, Model model) {
        List<Schedule> listOfSchedule = reservationService.getScheduleForMovie(movie_id);
        Movie movie = movieService.findMovieById(movie_id);
        System.out.println(movie.toString());
        model.addAttribute("listOfSchedule", listOfSchedule);
        model.addAttribute("title", movie.getTitle());
        return "Time";
    }




}
