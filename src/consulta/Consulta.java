/*
Tarea de hilos: Extends thread
Estudiante: Palacio Zambrano José Enrique

Se requieren realizar actividades independientes de tabla:
    1) consulta.Consulta clientes de saldo=0
    2) consulta.Consulta clientes registrados en el sistema a partir 1-1-2020
Calcule sus tiempos (seg)
*/


package consulta;

import java.time.Instant;

public class Consulta {

    public static void main(String[] args) {
        Instant startTime = Instant.now();

        Cliente0 hilo1=new Cliente0(startTime);hilo1.start();
        ClienteCreacion hilo2=new ClienteCreacion(startTime);hilo2.start();


    }
}
