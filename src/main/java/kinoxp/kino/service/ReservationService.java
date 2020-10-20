package kinoxp.kino.service;

import kinoxp.kino.model.Schedule;
import kinoxp.kino.model.Ticket;
import kinoxp.kino.repository.MovieRepository;
import kinoxp.kino.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> getScheduleForMovie (int movie_id){
        return movieRepository.fetchSchedule(movie_id);
    }
    public void saveTicket(Ticket ticket){
        movieRepository.saveTicket(ticket);
    }
    public void changeNumberOfTakenSeats(Ticket ticket){
        scheduleRepository.changeNumberOfTakenSeats(ticket);
    }
}
