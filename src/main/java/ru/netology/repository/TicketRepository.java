package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domein.Ticket;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRepository extends Ticket {

    TicketRepository repository = new TicketRepository();

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
        for (Ticket product : tickets) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
            tickets = tmp;
        }
    }

    public Ticket[] findAll() {
        return tickets;
    }
}
