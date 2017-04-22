package com.urrego.heriberto.metodosordenamiento;

/**
 * Created by Afuro,Heriberto on 20/04/17.
 */
public class ConversionTiempo {

    public static void getTiempoEjecucion (long time_end, long time_start){

        float tiempoMili = time_end - time_start;

        float tiempo = (time_end - time_start)/1000;

        if((tiempo > 60) && (tiempo < 3600)){
            System.out.println("tiempo de ejecución: "+ tiempo/60 +" minutos\n");
        }else if(tiempo > 3600) {
            System.out.println("tiempo de ejecución: "+ tiempo/3600 +" horas\n");
        }else if((tiempo > 0) && (tiempo < 60)){
            System.out.println("tiempo de ejecución: "+ tiempo +" segundos\n");
        }else{
            System.out.println("tiempo de ejecución: "+ tiempoMili +" milisegundos\n");
        }

    }
}
