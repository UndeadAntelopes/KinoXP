package kinoxp.kino;

import kinoxp.kino.model.Ticket;
import kinoxp.kino.repository.MovieRepository;
import kinoxp.kino.repository.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReservationTest {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    @Test
    public void saveTicketsTest(){
        Ticket ticket = new Ticket(15,"Nesrin", 3, 1, 1);
        movieRepository.saveTicket(ticket);
        assertEquals(ticket.getName(), movieRepository.findTicketById(15).getName());
    }

    @Test
    public void changeNumberOfTakenSeats(){
        Ticket ticket = new Ticket(25,"Dagmara", 3, 1, 1);
        movieRepository.saveTicket(ticket);
        scheduleRepository.changeNumberOfTakenSeats(ticket);
        assertEquals(15,scheduleRepository.findScheduleById(1).getTaken_seat());
    }


}
