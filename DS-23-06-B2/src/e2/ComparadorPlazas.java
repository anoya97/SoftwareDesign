package e2;

import java.util.Comparator;

public class ComparadorPlazas implements Comparator<Apartamentos> {
    @Override
    public int compare (Apartamentos ap1, Apartamentos ap2){
        return Integer.compare((ap1.getPlazas()),(ap2.getPlazas()));
    }
}
