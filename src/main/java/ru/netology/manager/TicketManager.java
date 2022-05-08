package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domein.Ticket;
import ru.netology.repository.TicketRepository;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketManager extends Ticket {
    TicketManager manager = new TicketManager();
    protected TicketRepository repository = new TicketRepository();

    public void addTicket(Ticket ticket) {
        repository.addTicket(ticket);
    }

    public void findAllTo() {
        repository.findAll();
    }

    public void findAllFrom() {
        repository.findAll();
    }

    public Ticket[] searchBy(String departure, String arrival) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll())
            if (matchesDeparture(ticket, departure, arrival)) {
                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int findTicket = tmp.length - 1;
                tmp[findTicket] = ticket;
                result = tmp;
            }
        return result;
    }

    public boolean matchesDeparture(Ticket ticket, String departure, String arrival) {
        if (!ticket.getDeparture().equals(departure)) {
            return false;
        }
        if (!ticket.getArrival().equals(arrival)) {
            return false;
        }
        return true;
    }
}