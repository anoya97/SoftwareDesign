package e1;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class API_Tickets {
    private List<Tickets> tickets = new ArrayList<>();
    public void setTickets(List<Tickets> tickets) {

        this.tickets = tickets;
    }

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void addTickets(Tickets ticketAdd){
        tickets.add(ticketAdd);
    }

    public void resetFiltros(List<Tickets> tickets){
        tickets.clear();
        setTickets(tickets);
    }

    public void buscar(Operaciones operacion, SearchingBar... propiedades){
        this.tickets = operacion.operar(tickets, propiedades);
    }

    public String imprimir (List<Tickets> tickets){
        StringBuilder sb = new StringBuilder();
        for (Tickets ticket : tickets) {
            sb.append(ticket.toString()).append('\n');
        }
        return sb.toString().trim();
    }
}
