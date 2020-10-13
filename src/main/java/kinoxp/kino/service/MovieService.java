package kinoxp.kino.service;

import kinoxp.kino.model.Movie;
import kinoxp.kino.model.Schedule;
import kinoxp.kino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> fetchAll() {
        return movieRepository.fetchAll();
    }
    public ArrayList<Schedule> allSchedules() {
        //Retrieve all schedules from the database
        ArrayList<Schedule> schedules = (ArrayList<Schedule>) movieRepository.fetchSchedule();
        return schedules;
    }
    public ArrayList<Movie> fetchCurrentMovies() {
        ArrayList<Schedule> schedules = currentSchedule();

        //Extract list of schedules for the query
        String numbers = "";
        for (int i = 0; i < schedules.size(); ++i) {
            numbers += schedules.get(i).getScheduleId();
            if (i != schedules.size() - 1) {
                numbers += ", ";
            }
        }

        return (ArrayList<Movie>) movieRepository.fetchCurrentMovies(numbers);
    }

    public Movie addMovie(Movie m) {
        return movieRepository.addMovie(m);
    }

    public ArrayList<Schedule> currentSchedule() {
            ArrayList<Schedule> schedules = allSchedules();

            //Store current time and declare a parser
            DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            LocalDateTime today = LocalDateTime.now();

            //Loop to filter schedules for only currently showing movies
            int currentMonth = today.getMonthValue();
            for (int i = 0; i < schedules.size(); ++i) {
                //Isolate month from DateTime string
                int month = Integer.parseInt(schedules.get(i).getStart().substring(5, 7));

                //
                if (!(month >= currentMonth && month < (currentMonth + 3))) {
                    schedules.remove(i);
                }
            }
            return schedules;


    }

    public void updateMovie(Movie movie) {movieRepository.updateMovie(movie);}

    public boolean deleteMovie(int id) { return movieRepository.deleteMovie(id);}

    public Movie findMovieById(int id) {
        return movieRepository.findMovieById(id);
    }



}
