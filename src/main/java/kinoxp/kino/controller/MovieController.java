package kinoxp.kino.controller;

import kinoxp.kino.model.*;
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
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping("/movieList")
    public String displayAllMovies(Model model) {
        ArrayList<Movie> movies = movieService.fetchCurrentMovies();
        //If there are no movies currently showing, just display
        //an empty list.
        if (movies == null) {
            movies = new ArrayList<>();
        }
        List<Movie> oldMovies = movieService.fetchAll();

        model.addAttribute("movies", movies);
        model.addAttribute("oldMovies", oldMovies);
        return "MovieList.html";
    }

    @GetMapping("/currentlyShowing/ordered")
    public String displayOrderedCurrentMovies(Model model) {
        ArrayList<Movie> unorderedMovies = movieService.fetchCurrentMovies();
        ArrayList<Movie> movies = movieService.sortByGenre(unorderedMovies);
        model.addAttribute("movies", movies);

        //Show oldMovies (unsorted) for consistency
        List<Movie> oldMovies = movieService.fetchAll();
        model.addAttribute("oldMovies", oldMovies);
        return "MovieList.html";
    }
    
    //show update movie form
    @GetMapping("/updateMovie/{id}")
    public String updateMovie(@PathVariable("id") int id, Model model){
        model.addAttribute("movie",movieService.findMovieById(id));
        //model.addAttribute("categories",categoryService.showCountriesList());
        return "updateMovie";
    }

    //update movie information
    @PostMapping("/updateMovie/{id}")
    public String updateMovie(@ModelAttribute Movie movie, @PathVariable("id") int id){
        movie.setMovieId(id);
        movieService.updateMovie(movie);
        return "redirect:/movieList";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") int id, Model model) {
        movieService.deleteMovie(id);
        return "redirect:/movieList";
    }


    @GetMapping ("/add")
    public String add() {
        return "add";
    }

    @PostMapping ("/add")
    public String add(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/movieList";
    }

    @GetMapping ("/setSchedule")
    public String setSchedule(Model model) {
        model.addAttribute("movies", movieService.fetchAll());
        return "setSchedule";
    }

    @PostMapping ("/setSchedule")
    public String setSchedule(@ModelAttribute Schedule schedule, @ModelAttribute Movie movieId){
        movieService.addSchedule(schedule);

        //Retrieve last added schedule's id
        List<Schedule> schedules =  movieService.allSchedules();
        movieService.assignMovieToSchedule(movieId.getMovieId(), schedules.get(schedules.size()-1).getScheduleId());
        return "redirect:/movieList";
    }
}
