
package e2;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AlquilerTest {
    private final Alquiler alquiler = new Alquiler();
    @Test
    void testAdd(){
        Apartamentos ap1=new Apartamentos(123999,1000,65,2,155,15000);
        Apartamentos ap2=new Apartamentos(123455,950,45,3,100,15002);
        alquiler.getApartamentosList().add(ap1);
        assertTrue(alquiler.getApartamentosList().contains(ap1));
        assertFalse(alquiler.getApartamentosList().contains(ap2));
    }


    @Test
    void testHashcode() {
        Apartamentos ap1= new Apartamentos(123458,900,50,1,130,15001);
        Apartamentos ap2= new Apartamentos(123458,900,50,1,130,15001);
        Apartamentos ap3= new Apartamentos(123458,1000,50,1,130,15001);
        assertEquals(ap1.hashCode(),ap2.hashCode());
        assertNotEquals(ap2.hashCode(),ap3.hashCode());
        assertNotEquals(ap1.hashCode(),ap3.hashCode());
    }



    @Test
    void ordenReferencia(){
        alquiler.setComparator(null);
        Apartamentos ap1  = new Apartamentos(123, 1200, 4, 5, 159, 34543);
        Apartamentos ap2 = new Apartamentos(12345, 1200, 4, 5, 160, 34543);
        Apartamentos ap3 = new Apartamentos(1231, 1200, 4, 5, 150, 34543);
        alquiler.getApartamentosList().add(ap1);
        alquiler.getApartamentosList().add(ap2);
        alquiler.getApartamentosList().add(ap3);

        alquiler.getApartamentosList().sort(alquiler.getComparator());
        assertEquals(ap1, alquiler.getApartamentosList().get(2));
        assertEquals(ap2, alquiler.getApartamentosList().get(0));
        assertEquals(ap3, alquiler.getApartamentosList().get(1));

    }
    @Test
    void ordenTPrize(){
        ComparatorPrecioTotal comparatorPrecioTotal1 = new ComparatorPrecioTotal();
        alquiler.setComparator(comparatorPrecioTotal1);
        Apartamentos ap1  = new Apartamentos(1123, 1200, 50, 2, 159, 34543);
        Apartamentos ap2 = new Apartamentos(1123, 1300, 50, 1, 160, 34543);
        Apartamentos ap3 = new Apartamentos(1123, 1100, 50, 0, 150, 34543);
        alquiler.getApartamentosList().add(ap1);
        alquiler.getApartamentosList().add(ap2);
        alquiler.getApartamentosList().add(ap3);

        alquiler.getApartamentosList().sort(alquiler.getComparator());
        assertEquals(ap1, alquiler.getApartamentosList().get(1));
        assertEquals(ap2, alquiler.getApartamentosList().get(2));
        assertEquals(ap3, alquiler.getApartamentosList().get(0));

    }
    @Test
    void ordenPrize(){
        ComparatorPrecio comparatorPrecio1 = new ComparatorPrecio();
        alquiler.setComparator(comparatorPrecio1);
        Apartamentos ap1  = new Apartamentos(1123, 1200, 4, 5, 159, 34543);
        Apartamentos ap2 = new Apartamentos(1123, 1300, 4, 5, 160, 34543);
        Apartamentos ap3 = new Apartamentos(1123, 1435, 4, 5, 150, 34543);
        alquiler.getApartamentosList().add(ap1);
        alquiler.getApartamentosList().add(ap2);
        alquiler.getApartamentosList().add(ap3);

        alquiler.getApartamentosList().sort(alquiler.getComparator());
        assertEquals(ap1, alquiler.getApartamentosList().get(0));
        assertEquals(ap2, alquiler.getApartamentosList().get(1));
        assertEquals(ap3, alquiler.getApartamentosList().get(2));
    }
    @Test
    void ordenPlaza(){
        ComparadorPlazas comparadorPlazas1 = new ComparadorPlazas();
        alquiler.setComparator(comparadorPlazas1);
        Apartamentos ap1  = new Apartamentos(1123, 1200, 4, 6, 159, 34543);
        Apartamentos ap2 = new Apartamentos(1123, 1200, 4, 3, 160, 34543);
        Apartamentos ap3 = new Apartamentos(1123, 1200, 4, 2, 150, 34543);
        alquiler.getApartamentosList().add(ap1);
        alquiler.getApartamentosList().add(ap2);
        alquiler.getApartamentosList().add(ap3);

        alquiler.getApartamentosList().sort(alquiler.getComparator());
        assertEquals(ap1, alquiler.getApartamentosList().get(2));
        assertEquals(ap2, alquiler.getApartamentosList().get(1));
        assertEquals(ap3, alquiler.getApartamentosList().get(0));
    }
    @Test
    void ordenSize(){
        ComparatorTamanho comparatorTamanho1 = new ComparatorTamanho();
        alquiler.setComparator(comparatorTamanho1);
        Apartamentos ap1  = new Apartamentos(1123, 1200, 4, 5, 159, 34543);
        Apartamentos ap2 = new Apartamentos(1123, 1200, 4, 5, 160, 34543);
        Apartamentos ap3 = new Apartamentos(1123, 1200, 4, 5, 150, 34543);
        alquiler.getApartamentosList().add(ap1);
        alquiler.getApartamentosList().add(ap2);
        alquiler.getApartamentosList().add(ap3);
        alquiler.getApartamentosList().sort(alquiler.getComparator());
        assertEquals(ap1, alquiler.getApartamentosList().get(1));
        assertEquals(ap2, alquiler.getApartamentosList().get(2));
        assertEquals(ap3, alquiler.getApartamentosList().get(0));

    }

    @Test
    void testExceptions() {
        assertThrows(IllegalArgumentException.class, () -> new Apartamentos(-2,1000,65,2,155,15000));
        assertThrows(IllegalArgumentException.class, () -> new Apartamentos(123455,0,45,3,100,15002));
        assertThrows(IllegalArgumentException.class, () -> new Apartamentos(123999,1000,0,2,155,15000));
        assertThrows(IllegalArgumentException.class, () -> new Apartamentos(123999,1000,65,2,0,15000));
        assertThrows(IllegalArgumentException.class, () -> new Apartamentos(123455,950,45,3,100,0));
        assertThrows(IllegalArgumentException.class, () -> new Apartamentos(123455,-3,45,3,100,15002));
    }
}
