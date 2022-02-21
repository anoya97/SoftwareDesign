package e1;

import java.util.List;

public interface Operaciones {
    List<Tickets> operar(List<Tickets> tickets, SearchingBar... propiedades);  // Según el parámetro que le pases a la función buscar definida en API_Tickets, usa la implementación AND o OR.
}
