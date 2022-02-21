package e1;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record Fecha(LocalDateTime fecha) implements SearchingBar {

    @Override
    public String toString() {
        return "\tFecha[" + fecha.getDayOfMonth() + '/' + fecha.getMonth() + '/' + fecha.getYear() + " Hora: "
                + fecha.getHour() + ':' + fecha.getMinute() + ':' + fecha.getSecond() + ']'
                + '\t';
    }

    @Override
    public List<Tickets> filtrado(List<Tickets> tickets) {
        return tickets.stream().filter(tickets1 -> tickets1.getFecha().equals(this)).collect(Collectors.toList());
    }
}
