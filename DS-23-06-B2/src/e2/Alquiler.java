package e2;


import java.util.*;
import java.util.ArrayList;

public class Alquiler {
    private final List<Apartamentos> apartamentosList = new ArrayList<>();
    private Comparator<Apartamentos> comparator = null;
    public void setComparator(Comparator<Apartamentos> comparator) {
        this.comparator = comparator;
    }
    List<Apartamentos> getApartamentosList() {return apartamentosList;}
    Comparator<Apartamentos> getComparator() {
        return comparator;
    }
}