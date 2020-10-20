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
    private int taken_seat;
    private int availableSeats;

    public Schedule(int scheduleId, String start, String end, int roomId, int taken_seat) {
        this.scheduleId = scheduleId;
        this.start = start;
        this.end = end;
        this.roomId = roomId;
        if (roomId == 1){
            this.availableSeats = 240;
        }else {
            this.availableSeats = 400;
        }
        this.taken_seat = taken_seat;
    }

    public Schedule() {
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
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
        if (roomId == 1){
            this.availableSeats = 240;
        }else {
            this.availableSeats = 400;
        }
    }

    public int getTaken_seat() {
        return taken_seat;
    }

    public void setTaken_seat(int taken_seat) {
        this.taken_seat = taken_seat;
    }
}
