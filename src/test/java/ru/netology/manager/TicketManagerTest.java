package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import ru.netology.domein.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketManagerTest {
    Ticket ticket1 = new Ticket(1, 20000, "DME", "LED", 90);
    Ticket ticket2 = new Ticket(2, 12000, "VKO", "FRU", 180);
    Ticket ticket3 = new Ticket(3, 43000, "SVO", "WDH", 1200);

    @Test
    public void allTicketsWithoutRemove() {
        TicketRepository repo = new TicketRepository();
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);

        repo.removeTicketByID(2);

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTicketByDeparture() {
        TicketManager manager = new TicketManager();
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.searchBy("DME", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTicketByArrival() {
        TicketManager manager = new TicketManager();
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchBy("SVO", "WDH");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByLowPrice() {
        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = {ticket1, ticket2, ticket3};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
}
