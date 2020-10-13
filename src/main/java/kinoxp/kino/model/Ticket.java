package kinoxp.kino.model;

public class Ticket {
    private int ticketId;
    private String name;

    public Ticket() {
    }

    public Ticket(int ticketId, String name) {
        this.ticketId = ticketId;
        this.name = name;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", name='" + name + '\'' +
                '}';
    }
}
