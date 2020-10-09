package kinoxp.kino.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cinema {
    @Id
    private int cinema_id;
    private int seats;

    public Cinema() {
    }

    public Cinema(int cinema_id, int seats) {
        this.cinema_id = cinema_id;
        this.seats = seats;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cinema_id=" + cinema_id +
                ", seats=" + seats +
                '}';
    }
}
