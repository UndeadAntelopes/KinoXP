package kinoxp.kino.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schedule {
    @Id
    private int scheduleId;
    private String start;
    private String end;
    private int roomId;
    private int takenSeats;

    public Schedule(int scheduleId, String start, String end, int roomId, int takenSeats) {
        this.scheduleId = scheduleId;
        this.start = start;
        this.end = end;
        this.roomId = roomId;
        this.takenSeats = takenSeats;
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getTakenSeats() {
        return takenSeats;
    }

    public void setTakenSeats(int takenSeats) {
        this.takenSeats = takenSeats;
    }
}
