package kinoxp.kino.service;

import kinoxp.kino.model.Movie;
import kinoxp.kino.model.Schedule;
import kinoxp.kino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository repo;

    public List<Movie> fetchAll() {
        return repo.fetchAll();
    }


    public ArrayList<Movie> fetchCurrentMovies() {
        //Store all movies in a list
        ArrayList<Movie> currentMovies = (ArrayList<Movie>)repo.fetchAll();

        //Store current time and declare a parser
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime today = LocalDateTime.now();

        //Retrieve all schedules from the database
        ArrayList<Schedule> schedules = (ArrayList<Schedule>)repo.fetchSchedule();


        //Loop to filter schedules for only currently showing movies
        int currentMonth = today.getMonthValue();
        for (int i = 0; i < schedules.size(); ++i) {
            int month = Integer.parseInt(schedules.get(i).getStart().substring(5, 7));

            if (!(month >= currentMonth && month < (currentMonth + 3))) {
                schedules.remove(i);
            }
        }

        //Extract list of schedules for the query
        String numbers = "";
        for (int i = 0; i < schedules.size(); ++i) {
            numbers += schedules.get(i);
            if (i != schedules.size() - 1) {
                numbers += ", ";
            }
        }
    }

}
