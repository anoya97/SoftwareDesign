package e1;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;


public record Precio(Float precio) implements SearchingBar {

    private boolean precioMenorIgualQue(Object other) {
        Precio otherPrecio = (Precio) other;
        return (this.precio <= otherPrecio.precio);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String formatted = df.format(precio);
        return "Precio: " + formatted + '€';
    }

    @Override
    public List<Tickets> filtrado(List<Tickets> tickets) {
        return tickets.stream().filter(tickets1 -> tickets1.getPrecio().precioMenorIgualQue(this)).collect(Collectors.toList());
    }
}
