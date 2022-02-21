package e2;


import java.util.Comparator;

public class ComparatorPrecio implements Comparator<Apartamentos> {
    @Override
    public int compare (Apartamentos ap1, Apartamentos ap2){
        return Integer.compare((ap1.getPrecioBase()),(ap2.getPrecioBase()));
    }
}