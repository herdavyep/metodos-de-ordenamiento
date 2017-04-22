package com.urrego.heriberto.metodosordenamiento.metodos;

import com.urrego.heriberto.metodosordenamiento.MetodosArchivoTxt;
import com.urrego.heriberto.metodosordenamiento.ConversionTiempo;

import java.io.IOException;


/**
 * Created by Afuro,Heriberto on 18/04/2017.
 */
public class Insercion implements InterfaceMetodo{
    @Override
    public void ordenamiento(int[] arregloint) throws IOException {

        long time_start, time_end;

        time_start = System.currentTimeMillis();

        System.out.println("Inicia ordenamiento por Insercion..");

        int auxiliar;
        for (int i = 1; i < arregloint.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arregloint[j] < arregloint[j-1]){
                    auxiliar = arregloint[j];
                    arregloint[j] = arregloint[j-1];
                    arregloint[j-1] = auxiliar;
                }
            }
        }

        MetodosArchivoTxt.guardarEnTxt(arregloint);

        time_end = System.currentTimeMillis();

        ConversionTiempo.getTiempoEjecucion(time_end, time_start);

    }
}
