package e1;

import java.util.Objects;

public final class Tickets {
    private final Destino destino;
    private final Fecha fecha;
    private final Precio precio;
    private final Origen origen;

    public Tickets(Destino destino, Fecha fecha, Precio precio, Origen origen) {  // Constructor.
        this.destino = destino;
        this.fecha = fecha;
        this.precio = precio;
        this.origen = origen;
    }


    public Destino getDestino() {
        return destino;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Origen getOrigen() {
        return origen;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return Objects.equals(destino, tickets.destino) && Objects.equals(fecha, tickets.fecha) && Objects.equals(precio, tickets.precio) && Objects.equals(origen, tickets.origen);
    }

    @Override
    public String toString() {
        return "Ticket { "+ origen + destino + fecha + precio +" }";
    }
}
