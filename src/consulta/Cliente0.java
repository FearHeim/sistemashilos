package consulta;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Cliente0 extends Thread{

    private Instant startTime;

    public Cliente0(Instant startTime) {
        this.startTime = startTime;
    }

    @Override

    public void run(){


        String [][] tabla =new Tabla().getData();

        ArrayList <String[]> datosImpresos = new ArrayList<>();
        for (String [] datosTabla:
             tabla) {
            if (Integer.parseInt(datosTabla[1])==0){
                datosImpresos.add(datosTabla);
            }
        }
        for (String [] datosTabla:
             datosImpresos) {
            System.out.println("El cliente " + datosTabla[0] + " tiene un saldo de " + datosTabla[1]);
        }

        Instant endTime = Instant.now();

        Duration finalTime=Duration.between(startTime, endTime);

        System.out.println("El tiempo en mostrar los clientes con saldo 0 fue de: " +finalTime.toMillis()+ "ms");
        System.out.println("__________________________________________________________________");

    }

}


