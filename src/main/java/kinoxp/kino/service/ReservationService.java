package kinoxp.kino.service;

import kinoxp.kino.model.Schedule;
import kinoxp.kino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    MovieRepository movieRepository;

    public List<Schedule> getScheduleForMovie (int movie_id){
        return movieRepository.fetchSchedule(movie_id);
    }
}
