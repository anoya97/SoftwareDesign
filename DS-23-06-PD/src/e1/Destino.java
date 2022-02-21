package e1;
import java.util.List;
import java.util.stream.Collectors;


public record Destino(String destino) implements SearchingBar {

    @Override
    public String toString() {
        return "Destino: " + destino;
    }

    @Override
    public List<Tickets> filtrado(List<Tickets> tickets) {
        return tickets.stream().filter(tickets1 -> tickets1.getDestino().equals(this)).collect(Collectors.toList());
    }
}
