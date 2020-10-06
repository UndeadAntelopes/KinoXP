package kinoxp.kino.controller;

import kinoxp.kino.model.Movie;
import kinoxp.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    //show update movie form
    @GetMapping("/updateMovie/{id}")
    public String updateMovie(@PathVariable("id") int id, Model model){
        //model.addAttribute("movie",movieService.findMovieById(id));
        //model.addAttribute("categories",categoryService.showCountriesList());
        return "updateMovie";
    }

    //update movie information
    @PostMapping("/updateMovie/{id}")
    public String updateMovie(@ModelAttribute Movie movie, @PathVariable("id") int id){
        movieService.updateMovie(movie);
        return "redirect:/viewMovies";
    }

    @GetMapping("/deleteRenter/{id}")
    public String deleteRenter(@PathVariable("id") int id, Model model) {
        movieService.deleteMovie(id);
        return "redirect:/viewMovies";
    }




}
