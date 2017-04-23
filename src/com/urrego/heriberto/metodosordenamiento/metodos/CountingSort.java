package com.urrego.heriberto.metodosordenamiento.metodos;

import com.urrego.heriberto.metodosordenamiento.MetodosArchivoTxt;
import com.urrego.heriberto.metodosordenamiento.ConversionTiempo;

import java.io.IOException;

/**
 * Created by Afuro,Heriberto on 20/04/17.
 */
public class CountingSort implements InterfaceMetodo{


    @Override
    public void ordenamiento(int[] arregloint) throws IOException {

        long time_start, time_end;

        time_start = System.currentTimeMillis();

        System.out.println("Inicia ordenamiento por Couting..");


        int[] aux = new int[arregloint.length];

        int min = arregloint[0];
        int max = arregloint[0];
        for (int i = 1; i < arregloint.length; i++) {
            if (arregloint[i] < min) {
                min = arregloint[i];
            } else if (arregloint[i] > max) {
                max = arregloint[i];
            }
        }

        int[] counts = new int[max - min + 1];

        for (int i = 0;  i < arregloint.length; i++) {
            counts[arregloint[i] - min]++;
        }

        counts[0]--;
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i-1];
        }

        for (int i = arregloint.length - 1; i >= 0; i--) {
            aux[counts[arregloint[i] - min]--] = arregloint[i];
        }

        MetodosArchivoTxt.guardarEnTxt(arregloint);

        time_end = System.currentTimeMillis();

        ConversionTiempo.getTiempoEjecucion(time_end, time_start);
    }

}
