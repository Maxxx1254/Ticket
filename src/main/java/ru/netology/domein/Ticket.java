package ru.netology.domein;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String departure;
    protected String arrival;
    protected int travelTime;

    public Ticket[] tickets = new Ticket[0];

    public Ticket(int id, int price, String departure, String arrival, int travelTime) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && travelTime == ticket.travelTime && Objects.equals(departure, ticket.departure) && Objects.equals(arrival, ticket.arrival) && Arrays.equals(tickets, ticket.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departure, arrival, travelTime);
    }

    @Override
    public int compareTo(Ticket o) {
        var ticket = (Ticket) o;
        return this.price - ticket.price;
    }
}
