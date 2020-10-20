package kinoxp.kino.model;

public class Ticket {
    private int ticketId;
    private String name;
    private int amount;
    private int movieId;
    private int scheduleId;

    public Ticket() {
    }

    public Ticket(int ticketId, String name, int amount, int movieId, int scheduleId) {
        this.ticketId = ticketId;
        this.name = name;
        this.amount = amount;
        this.movieId = movieId;
        this.scheduleId = scheduleId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
