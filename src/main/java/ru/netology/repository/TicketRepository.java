package ru.netology.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domein.Ticket;

@Data
@NoArgsConstructor
public class TicketRepository extends Ticket {

    Ticket[] tickets = new Ticket[0];

    public void addTicket(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastTicket = tmp.length - 1;
        tmp[lastTicket] = ticket;
        tickets = tmp;
    }

    public void removeTicketByID(int id) {
        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
            tickets = tmp;
        }
    }

    public Ticket[] findAll() {
        return tickets;
    }
}
