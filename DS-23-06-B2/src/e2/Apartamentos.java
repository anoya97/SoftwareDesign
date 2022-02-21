package e2;


public class Apartamentos implements Comparable<Apartamentos>{
    private final int ref;
    private final int precioBase;
    private final int precioPlazas;
    private final int plazas;
    private final int tamanho;
    private final int cP;
    private final int precioTotal;

    public Apartamentos(int ref, int precioBase, int precioPlazas, int plazas, int tamanho, int cP) {
        if (ref < 0){
            throw new IllegalArgumentException();
        } else {
            this.ref=ref;
        }
        if (precioBase>0 && precioPlazas>0 && tamanho>0 && cP>0 ){
            this.precioBase=precioBase;
            this.precioPlazas=precioPlazas;
            this.tamanho=tamanho;
            this.cP=cP;
        } else {
            throw new IllegalArgumentException();
        }
        this.plazas=plazas;
        this.precioTotal=precioBase + precioPlazas*plazas;
    }

    public int getPrecioBase(){
        return precioBase;
    }
    public int getPrecioPlazas(){
        return precioPlazas;
    }
    public int getPlazas(){
        return plazas;
    }
    public int getTamanho(){
        return tamanho;
    }
    public int getcP(){
        return cP;
    }
    public int getPrecioTotal(){
        return precioTotal;
    }

    @Override
    public int compareTo (Apartamentos o){
        return Integer.compare(o.ref , this.ref);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamentos that = (Apartamentos) o;
        return precioBase == that.precioBase && precioPlazas == that.precioPlazas && plazas == that.plazas && tamanho == that.tamanho && cP == that.cP && precioTotal == that.precioTotal;
    }
    @Override
    public int hashCode () {
        int codigoHash;
        codigoHash = 31 * this.getPrecioBase() +
                31 * this.getPrecioPlazas() +
                31 * this.getPlazas() +
                31 * this.getTamanho() +
                31 * this.getcP() +
                31 * this.getPrecioTotal();
        return codigoHash;
    }
}
