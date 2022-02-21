package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Operacion_OR implements Operaciones{
    @Override
    public List<Tickets> operar(List<Tickets> tickets, SearchingBar... propiedades) {
        List<Tickets> ticketsFiltrados = new ArrayList<>();
        for(int i = 0; i< propiedades.length; i++){
           ticketsFiltrados.addAll(propiedades[i].filtrado(tickets));
        }
        return  ticketsFiltrados.stream().distinct().collect(Collectors.toList());
    }
}