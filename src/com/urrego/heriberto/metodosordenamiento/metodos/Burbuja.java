package com.urrego.heriberto.metodosordenamiento.metodos;

import com.urrego.heriberto.metodosordenamiento.MetodosArchivoTxt;
import com.urrego.heriberto.metodosordenamiento.ConversionTiempo;

import java.io.*;

/**
 * Created by Afuro,Heriberto on 18/04/2017.
 */
public class Burbuja implements InterfaceMetodo{

    @Override
    public void ordenamiento(int[] arregloint) throws IOException {

        long time_start, time_end;

        time_start = System.currentTimeMillis();

        System.out.println("Inicia ordenamiento por Burbuja..");

        int bufferburbuja;
        int i,j;
        for(i = 0; i < arregloint.length; i++)
        {
            for(j = 0; j < i; j++)
            {
                if(arregloint[i] < arregloint[j])
                {
                    bufferburbuja = arregloint[j];
                    arregloint[j] = arregloint[i];
                    arregloint[i] = bufferburbuja;
                }
            }
        }

        MetodosArchivoTxt.guardarEnTxt(arregloint);

        time_end = System.currentTimeMillis();

        ConversionTiempo.getTiempoEjecucion(time_end, time_start);
    }

}
