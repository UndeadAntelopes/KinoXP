package kinoxp.kino.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    private int room_id;
    private String name;
    private int seats;

    public Room() {
    }

    public Room(int room_id, String name, int seats) {
        this.room_id = room_id;
        this.name = name;
        this.seats = seats;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
