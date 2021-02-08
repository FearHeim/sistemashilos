package consulta;

import java.text.DateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ClienteCreacion extends Thread{

    private Instant startTime;

    public ClienteCreacion(Instant startTime) {
        this.startTime = startTime;
    }

    @Override

    public void run(){


        String [][] tabla =new Tabla().getData();

        Date fechaBusqueda=new Date(1577836800000L);
        ArrayList<String[]> datosImpresos = new ArrayList<>();
        for (String [] datosTabla:
                tabla) {

            Date fechaTabla=new Date(Long.parseLong(datosTabla[2]));
            if (fechaBusqueda.before(fechaTabla)){
                datosImpresos.add(datosTabla);
            }
        }
        for (String [] datosTabla:
                datosImpresos) {
            Date fechaTabla=new Date(Long.parseLong(datosTabla[2]));
            DateFormat formatoFecha= DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, Locale.forLanguageTag("es-ES"));
            String fechaFormateada = formatoFecha.format(fechaTabla);
            System.out.println("El cliente " + datosTabla[0] + " se registró en la fecha " + fechaFormateada);
        }

        Instant endTime = Instant.now();

        Duration finalTime=Duration.between(startTime, endTime);

        System.out.println("El tiempo en mostrar los clientes registrados luego del 1-1-2020 fue de: " +finalTime.toMillis()+ "ms");
        System.out.println("__________________________________________________________________");

    }
}
