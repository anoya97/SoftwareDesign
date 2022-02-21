package e1;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.*;

class API_TicketsTest {
    API_Tickets api_tickets = new API_Tickets();

    @Test
    public void testBusqueda(){
        Destino destCambre = new Destino("Cambre");
        Destino desSantiago = new Destino("Santiago");
        Destino desMadrid = new Destino("Madrid");
        Destino desBarcelona = new Destino("Barcelona");
        Destino desCoru = new Destino("Coruna");

        Origen origCoru = new Origen("Coruna");
        Origen origBarcelona = new Origen("Barcelona");
        Origen origMadrid = new Origen("Madrid");
        Origen origSantiago = new Origen("Santiago");
        Origen origCambre = new Origen("Cambre");

        LocalDateTime localDateTime1 = LocalDateTime.of(2021, Month.DECEMBER, 10, 13,42, 20);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, Month.DECEMBER, 23, 19, 30, 43);
        LocalDateTime localDateTime3 = LocalDateTime.of(2021, Month.DECEMBER, 26, 15, 36, 42);
        LocalDateTime localDateTime4 = LocalDateTime.of(2021, Month.DECEMBER, 31, 21, 34, 57);
        LocalDateTime localDateTime5 = LocalDateTime.of(2022, Month.DECEMBER, 5, 10, 30, 45);

        Fecha fechaPasada = new Fecha(localDateTime5);
        Fecha fechaPasada1 = new Fecha(localDateTime1);
        Fecha fechaChristmasEve = new Fecha(localDateTime2);
        Fecha fechaNavidad = new Fecha(localDateTime3);
        Fecha fechaNewYearsEve = new Fecha(localDateTime4);

        Precio precioDeluxe = new Precio(17.05f);
        Precio precioPremium = new Precio(10.45f);
        Precio precioStandard = new Precio(8.45f);
        Precio precioEstudiante = new Precio(5.67f);
        Precio precioNinos = new Precio(3.54f);
        Precio precioBebe = new Precio(1.9f);

        Tickets ticket1 = new Tickets(desCoru, fechaPasada1, precioBebe, origBarcelona);
        Tickets ticket2 = new Tickets(desCoru, fechaChristmasEve, precioNinos, origSantiago);
        Tickets ticket3 = new Tickets(desMadrid, fechaNavidad, precioDeluxe, origCambre);
        Tickets ticket4 = new Tickets(desBarcelona, fechaNewYearsEve, precioPremium, origCoru);
        Tickets ticket5 = new Tickets(desSantiago, fechaPasada1, precioBebe, origCambre);
        Tickets ticket6 = new Tickets(destCambre, fechaPasada, precioStandard, origMadrid);
        Tickets ticket7 = new Tickets(desCoru, fechaPasada1, precioEstudiante, origBarcelona);

        api_tickets.addTickets(ticket1);
        api_tickets.addTickets(ticket2);
        api_tickets.addTickets(ticket3);
        api_tickets.addTickets(ticket4);
        api_tickets.addTickets(ticket5);
        api_tickets.addTickets(ticket6);
        api_tickets.addTickets(ticket7);

        assertEquals(ticket1, api_tickets.getTickets().get(0));
        assertEquals(ticket2, api_tickets.getTickets().get(1));
        assertEquals(ticket3, api_tickets.getTickets().get(2));
        assertNotEquals(ticket1, api_tickets.getTickets().get(4));

        /* LISTA TICKETS INICIAL.
        Ticket { Origen: Barcelona	Destino: Coruna	Fecha[10/DECEMBER/2021 Hora: 13:42:20]	Precio: 1,90€ } <- ticket1
        Ticket { Origen: Santiago	Destino: Coruna	Fecha[23/DECEMBER/2021 Hora: 19:30:43]	Precio: 3,54€ } <- ticket2
        Ticket { Origen: Cambre	Destino: Madrid	Fecha[26/DECEMBER/2021 Hora: 15:36:42]	Precio: 17,05€ } <- ticket3
        Ticket { Origen: Coruna	Destino: Barcelona	Fecha[31/DECEMBER/2021 Hora: 21:34:57]	Precio: 10,45€ } <- ticket4
        Ticket { Origen: Cambre	Destino: Santiago	Fecha[10/DECEMBER/2021 Hora: 13:42:20]	Precio: 1,90€ } <- ticket5
        Ticket { Origen: Madrid	Destino: Cambre	Fecha[5/DECEMBER/2022 Hora: 10:30:45]	Precio: 8,45€ } <- ticket6
        Ticket { Origen: Barcelona	Destino: Coruna	Fecha[10/DECEMBER/2021 Hora: 13:42:20]	Precio: 5,67€ } <- ticket7
        */

        // Operaciones.
        Operacion_AND and = new Operacion_AND();
        Operacion_OR or = new Operacion_OR();



        //api_tickets.resetFiltros(api_tickets.getTickets());         // Se resetean los filtros, por lo que se vuelve a la lista inicial de tickets.
        assertEquals(ticket1, api_tickets.getTickets().get(0));

        assertNotEquals("Ticket { Origen: Cambre\tDestino: Madrid\tFecha[26/DECEMBER/2021 Hora: 15:36:42]\tPrecio: 17,05€ }\n" +
                "Ticket { Origen: Cambre\tDestino: Santiago\tFecha[10/DECEMBER/2021 Hora: 13:42:20]\tPrecio: 1,90€ }", api_tickets.imprimir(api_tickets.getTickets()));

    }


}