package kinoxp.kino.repository;

import kinoxp.kino.model.Schedule;
import kinoxp.kino.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleRepository {
    //Made se we can sort the schedule by cinema id
    @Autowired
    JdbcTemplate template;

    //Method that returns all tickets related to a certain movie showing
    //represented by a slot in the schedule
    public List<Ticket> getTicketsForSchedule(int scheduleId) {
        String query = "SELECT * FROM Ticket " +
                "WHERE Ticket.schedule_id = ?";
        RowMapper<Ticket> ticketsForSchedule = new BeanPropertyRowMapper<>(Ticket.class);
        //Remember to change this
        return template.query(query, ticketsForSchedule, scheduleId);
    }


}
