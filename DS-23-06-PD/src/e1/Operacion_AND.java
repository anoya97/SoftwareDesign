package e1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Operacion_AND implements Operaciones{
    @Override
    public List<Tickets> operar(List<Tickets> tickets, SearchingBar... propiedades) { // DESTINO1 ORIGEN1 FECHA3
        List<Tickets> ticketsFiltrados = new ArrayList<>();
        List<Tickets> auxiliar1 = new ArrayList<>();
        for(int i = 0; i < propiedades.length; i++){
            auxiliar1.addAll(propiedades[i].filtrado(tickets));
            for(int j = 0; j < auxiliar1.size(); j++){
                if(propiedades.length == Collections.frequency(auxiliar1, auxiliar1.get(j))){
                    ticketsFiltrados.add(auxiliar1.get(j));
                }
            }
        }
        return ticketsFiltrados.stream().distinct().collect(Collectors.toList());
    }
}
