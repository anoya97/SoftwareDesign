package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ColegioTest {
    private Colegio colegio;
    private final ArrayList<PersonalLaboral> personalLaboral = new ArrayList<>();
    private final ArrayList<Residentes> residentes = new ArrayList<>();

    @BeforeEach
    void setUp() {
        colegio = new Colegio();

        residentes.add(new Residentes("Hermione", "Granger", 15, 3, Residentes.Casas.GRYFFINDOR, Residentes.ResidenteTipo.ESTUDIANTE));
        residentes.add(new Residentes("Draco", "Malfoy", 17, 1, Residentes.Casas.SLYTHERIN, Residentes.ResidenteTipo.ESTUDIANTE));
        residentes.add(new Residentes("Cedric", "Diggory", 18, 2, Residentes.Casas.HUFFLEPUFF, Residentes.ResidenteTipo.ESTUDIANTE));
        residentes.add(new Residentes("Luna", "Lovegood", 15, 1, Residentes.Casas.RAVENCLAW, Residentes.ResidenteTipo.ESTUDIANTE));

        residentes.add(new Residentes("Nicholas", "Mimsy - Porpington", 91, 2, Residentes.Casas.GRYFFINDOR, Residentes.ResidenteTipo.FANTASMA));
        residentes.add(new Residentes("Helena", "Ravenclaw", 87, 3, Residentes.Casas.RAVENCLAW, Residentes.ResidenteTipo.FANTASMA));
        residentes.add(new Residentes("Fat", "Friar", 56, 5, Residentes.Casas.HUFFLEPUFF, Residentes.ResidenteTipo.FANTASMA));
        residentes.add(new Residentes("Baron", "Sanguinario", 134, 2, Residentes.Casas.SLYTHERIN, Residentes.ResidenteTipo.FANTASMA));

        personalLaboral.add(new Docentes("Cuthbert", "Binns", 23, 2, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.HISTORIA));
        personalLaboral.add(new Docentes("Pomona", "Sproutt", 57, 7, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.HERBOLOGIA));
        personalLaboral.add(new Docentes("Horace", "Slughorn", 35, 4, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.POCIONES));
        personalLaboral.add(new Docentes("Patricia", "Rakepick", 43, 2, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.DEFENSA));
        personalLaboral.add(new Docentes("Minerva", "McGonagall", 54, 1, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.TRANSFORMACIONES));


        personalLaboral.add(new Conserjes("Argus", "Filch", 36, 0, PersonalLaboral.Empleo.CONSERJE, false));
        personalLaboral.add(new Conserjes("Christina", "Farley", 27, 1, PersonalLaboral.Empleo.CONSERJE, true));

        personalLaboral.add(new GuardaBosques("Rubeus", "Hagrid", 34, 2, PersonalLaboral.Empleo.GUARDABOSQUE, true));
        personalLaboral.add(new GuardaBosques("Matthew", "Wilkie", 28, 1, PersonalLaboral.Empleo.GUARDABOSQUE, false));

    }

    @Test
    void testBasic(){
        Residentes residente1 = new Residentes("Harry", "Potter", 15, 2, Residentes.Casas.GRYFFINDOR, Residentes.ResidenteTipo.ESTUDIANTE);
        assertEquals("Harry", residente1.getName());
        assertEquals("Potter", residente1.getLastName());
        assertEquals(15, residente1.getAge());
        assertEquals(2, residente1.getHorrocrux());
        assertEquals(Residentes.Casas.GRYFFINDOR, residente1.getCasa());
        assertEquals(Residentes.ResidenteTipo.ESTUDIANTE, residente1.getResidenteTipo());
        assertEquals(2 * 90, residente1.Recompensa());

        Residentes residente2 = new Residentes("Draco", "Malfoy", 17, 1, Residentes.Casas.SLYTHERIN, Residentes.ResidenteTipo.ESTUDIANTE);
        assertEquals("Draco", residente2.getName());
        assertEquals("Malfoy", residente2.getLastName());
        assertEquals(17, residente2.getAge());
        assertEquals(1, residente2.getHorrocrux());
        assertEquals(Residentes.Casas.SLYTHERIN, residente2.getCasa());
        assertEquals(Residentes.ResidenteTipo.ESTUDIANTE, residente2.getResidenteTipo());
        assertEquals(residente2.getHorrocrux() * 90 * 2, residente2.Recompensa());

        Residentes fantasma1 = new Residentes("Nicholas", "Mimsy - Porpington", 91, 2, Residentes.Casas.GRYFFINDOR, Residentes.ResidenteTipo.FANTASMA);
        assertEquals("Nicholas", fantasma1.getName());
        assertEquals("Mimsy - Porpington", fantasma1.getLastName());
        assertEquals(91, fantasma1.getAge());
        assertEquals(2, fantasma1.getHorrocrux());
        assertEquals(Residentes.Casas.GRYFFINDOR, fantasma1.getCasa());
        assertEquals(Residentes.ResidenteTipo.FANTASMA, fantasma1.getResidenteTipo());
        assertNotEquals(2 * 90, fantasma1.Recompensa());
        assertEquals(2 * 80, fantasma1.Recompensa());

        PersonalLaboral docente1 = new Docentes("Cuthbert", "Binns", 23, 2, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.HISTORIA);
        assertEquals("Cuthbert", docente1.getName());
        assertEquals("Binns", docente1.getLastName());
        assertEquals(23, docente1.getAge());
        assertEquals(2, docente1.getHorrocrux());
        assertEquals(PersonalLaboral.Empleo.DOCENTE, docente1.getEmpleo());
        assertEquals(Docentes.Asignatura.HISTORIA, docente1.getAsignatura());
        assertEquals(50 * 2, docente1.Recompensa());
        assertEquals(200, docente1.Salario());
        assertFalse(docente1.isNocturno());

        PersonalLaboral docente2 = new Docentes("Patricia", "Rakepick", 43, 2, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.DEFENSA);
        assertEquals("Patricia", docente2.getName());
        assertEquals("Rakepick", docente2.getLastName());
        assertEquals(43, docente2.getAge());
        assertEquals(2, docente2.getHorrocrux());
        assertEquals(PersonalLaboral.Empleo.DOCENTE, docente2.getEmpleo());
        assertEquals(Docentes.Asignatura.DEFENSA, docente2.getAsignatura());
        assertEquals(2 * (0.75 * 50), docente2.Recompensa());
        assertEquals(500, docente2.Salario());

        PersonalLaboral conserje1 = new Conserjes("Christina", "Farley", 27, 1, PersonalLaboral.Empleo.CONSERJE, true);
        assertEquals("Christina", conserje1.getName());
        assertEquals("Farley", conserje1.getLastName());
        assertEquals(27, conserje1.getAge());
        assertEquals(1, conserje1.getHorrocrux());
        assertEquals(PersonalLaboral.Empleo.CONSERJE, conserje1.getEmpleo());
        assertTrue(conserje1.isNocturno());
        assertEquals(65, conserje1.Recompensa());
        assertEquals(150 + 10, conserje1.Salario());
        assertNull(conserje1.getAsignatura());

        PersonalLaboral guardabosque1 = new GuardaBosques("Matthew", "Wilkie", 28, 1, PersonalLaboral.Empleo.GUARDABOSQUE, false);
        assertEquals("Matthew", guardabosque1.getName());
        assertEquals("Wilkie", guardabosque1.getLastName());
        assertEquals(28, guardabosque1.getAge());
        assertEquals(1, guardabosque1.getHorrocrux());
        assertEquals(PersonalLaboral.Empleo.GUARDABOSQUE, guardabosque1.getEmpleo());
        assertFalse(guardabosque1.isNocturno());
        assertEquals(75, guardabosque1.Recompensa());
        assertEquals(170, guardabosque1.Salario());
        assertNull(guardabosque1.getAsignatura());

    }
    @Test
    void impresionnRecompensa(){
        String impresionRecompensas = "Cuthbert Binns (Docente de HISTORIA, 2.0 horrocruxes): 100.0 galeones. \n" +
                "Pomona Sproutt (Docente de HERBOLOGIA, 7.0 horrocruxes): 350.0 galeones. \n" +
                "Horace Slughorn (Docente de POCIONES, 4.0 horrocruxes): 200.0 galeones. \n" +
                "Patricia Rakepick (Docente de DEFENSA, 2.0 horrocruxes): 75.0 galeones. \n" +
                "Minerva McGonagall (Docente de TRANSFORMACIONES, 1.0 horrocruxes): 50.0 galeones. \n" +
                "Argus Filch (Conserje, 0.0 horrocruxes): 0.0 galeones. \n" +
                "Christina Farley (Conserje, 1.0 horrocruxes): 65.0 galeones. \n" +
                "Rubeus Hagrid (Guardabosque, 2.0 horrocruxes): 150.0 galeones. \n" +
                "Matthew Wilkie (Guardabosque, 1.0 horrocruxes): 75.0 galeones. \n" +
                "Hermione Granger (Estudiante de GRYFFINDOR, 3.0 horrocruxes): 270.0 galeones. \n" +
                "Draco Malfoy (Estudiante de SLYTHERIN, 1.0 horrocruxes): 180.0 galeones. \n" +
                "Cedric Diggory (Estudiante de HUFFLEPUFF, 2.0 horrocruxes): 180.0 galeones. \n" +
                "Luna Lovegood (Estudiante de RAVENCLAW, 1.0 horrocruxes): 90.0 galeones. \n" +
                "Nicholas Mimsy - Porpington (Fantasma de GRYFFINDOR, 2.0 horrocruxes): 160.0 galeones. \n" +
                "Helena Ravenclaw (Fantasma de RAVENCLAW, 3.0 horrocruxes): 240.0 galeones. \n" +
                "Fat Friar (Fantasma de HUFFLEPUFF, 5.0 horrocruxes): 400.0 galeones. \n" +
                "Baron Sanguinario (Fantasma de SLYTHERIN, 2.0 horrocruxes): 320.0 galeones. \n" +
                "La recompensa total del Colegio Hogwarts es de 2905.0 galeones.";
        assertEquals(impresionRecompensas, colegio.imprimirRecompensa(personalLaboral, residentes));
    }

    @Test
    void impresionnSalarios(){
        String impresionSalarios = "Cuthbert Binns (Docente de HISTORIA): 200 galeones.\n" +
                "Pomona Sproutt (Docente de HERBOLOGIA): 250 galeones.\n" +
                "Horace Slughorn (Docente de POCIONES): 350 galeones.\n" +
                "Patricia Rakepick (Docente de DEFENSA): 500 galeones.\n" +
                "Minerva McGonagall (Docente de TRANSFORMACIONES): 400 galeones.\n" +
                "Argus Filch (Conserje): 150 galeones.\n" +
                "Christina Farley (Conserje): 160 galeones.\n" +
                "Rubeus Hagrid (Guardabosque): 180 galeones.\n" +
                "Matthew Wilkie (Guardabosque): 170 galeones.\n" +
                "El gasto de Hogwarts en personal es de 2360.0 galeones.";
        assertEquals(impresionSalarios, colegio.imprimirSalarios(personalLaboral));
    }

    @Test
    void repetidosHistoria(){
        personalLaboral.add(new Docentes("Cuthbert", "Binns", 23, 2, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.HISTORIA));
        assertThrows(IllegalArgumentException.class, () -> colegio.imprimirRecompensa(personalLaboral, residentes));
        assertThrows(IllegalArgumentException.class, () -> colegio.imprimirSalarios(personalLaboral));

    }
    @Test
    void repetidosHerbologia(){
        personalLaboral.add(new Docentes("Pomona", "Sproutt", 57, 7, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.HERBOLOGIA));
        assertThrows(IllegalArgumentException.class, () -> colegio.imprimirRecompensa(personalLaboral, residentes));
        assertThrows(IllegalArgumentException.class, () -> colegio.imprimirSalarios(personalLaboral));
    }

    @Test
    void repetidosPociones(){
        personalLaboral.add(new Docentes("Horace", "Slughorn", 35, 4, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.POCIONES));;
        assertThrows(IllegalArgumentException.class, () -> colegio.imprimirRecompensa(personalLaboral, residentes));
        assertThrows(IllegalArgumentException.class, () -> colegio.imprimirSalarios(personalLaboral));
    }


    @Test
    void repetidosDefensa(){
        personalLaboral.add(new Docentes("Patricia", "Rakepick", 43, 2, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.DEFENSA));
        assertThrows(IllegalArgumentException.class, () -> colegio.imprimirRecompensa(personalLaboral, residentes));
        assertThrows(IllegalArgumentException.class, () -> colegio.imprimirSalarios(personalLaboral));
    }

    @Test
    void repetidosTransformaciones(){
        personalLaboral.add(new Docentes("Minerva", "McGonagall", 54, 1, PersonalLaboral.Empleo.DOCENTE, Docentes.Asignatura.TRANSFORMACIONES));
        assertThrows(IllegalArgumentException.class, () -> colegio.imprimirRecompensa(personalLaboral, residentes));
        assertThrows(IllegalArgumentException.class, () -> colegio.imprimirSalarios(personalLaboral));
    }
    @Test
    void testExceptions() {
        assertThrows(IllegalArgumentException.class, () -> new Residentes("", "Potter", 13, 14, Residentes.Casas.GRYFFINDOR, Residentes.ResidenteTipo.ESTUDIANTE));
        assertThrows(IllegalArgumentException.class, () -> new Residentes("Harry", "", 13, 14, Residentes.Casas.GRYFFINDOR, Residentes.ResidenteTipo.ESTUDIANTE));
        assertThrows(IllegalArgumentException.class, () -> new Residentes("Harry", "Potter", 0, 14, Residentes.Casas.GRYFFINDOR, Residentes.ResidenteTipo.ESTUDIANTE));
        assertThrows(IllegalArgumentException.class, () -> new Residentes("Harry", "Potter", -5, 14, Residentes.Casas.GRYFFINDOR, Residentes.ResidenteTipo.ESTUDIANTE));
        assertThrows(IllegalArgumentException.class, () -> new Residentes("Harry", "Potter", -5, 8, Residentes.Casas.GRYFFINDOR, Residentes.ResidenteTipo.ESTUDIANTE));
        assertThrows(IllegalArgumentException.class, () -> new Residentes("Harry", "Potter", 3, -1, Residentes.Casas.GRYFFINDOR, Residentes.ResidenteTipo.ESTUDIANTE));
    }

}