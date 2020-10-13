package kinoxp.kino;

import kinoxp.kino.repository.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KinoApplicationTests {
    @Autowired
    ScheduleRepository scheduleRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void selectTicketsBySchedule() {
        assertEquals(3, scheduleRepository.getTicketsForSchedule(1).size());
        assertEquals(2, scheduleRepository.getTicketsForSchedule(2).size());
        assertEquals(1, scheduleRepository.getTicketsForSchedule(3).size());
        assertEquals(1, scheduleRepository.getTicketsForSchedule(4).size());
        assertEquals(2, scheduleRepository.getTicketsForSchedule(5).size());
        assertEquals(0, scheduleRepository.getTicketsForSchedule(6).size());
    }
    
}
