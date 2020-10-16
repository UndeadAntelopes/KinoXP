package kinoxp.kino.model;

public class Ticket {
    private int ticketId;
    private String name;
    private int amount;

    public Ticket() {
    }

    public Ticket(int ticketId, String name, int amount) {
        this.ticketId = ticketId;
        this.name = name;
        this.amount = amount;
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
