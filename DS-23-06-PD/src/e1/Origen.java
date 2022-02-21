package e1;

import java.util.List;
import java.util.stream.Collectors;

public record Origen(String origen) implements SearchingBar {
    @Override
    public String toString() {
        return "Origen: " + origen + '\t';
    }


    @Override
    public List<Tickets> filtrado(List<Tickets> tickets) {
        return tickets.stream().filter(tickets1 -> tickets1.getOrigen().equals(this)).collect(Collectors.toList());
    }
}
