package kinoxp.kino.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schedule {
    @Id
    private int scheduleId;
    private String start;
    private String end;
    private int cinemaId;

    public Schedule(int scheduleId, String start, String end, int cinemaId) {
        this.scheduleId = scheduleId;
        this.start = start;
        this.end = end;
        this.cinemaId = cinemaId;
    }

    public Schedule() {
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", cinemaId=" + cinemaId +
                '}';
    }
}
