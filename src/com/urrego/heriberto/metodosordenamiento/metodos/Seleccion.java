package com.urrego.heriberto.metodosordenamiento.metodos;

import com.urrego.heriberto.metodosordenamiento.MetodosArchivoTxt;
import com.urrego.heriberto.metodosordenamiento.ConversionTiempo;

import java.io.IOException;

/**
 * Created by Afuro,Heriberto on 18/04/2017.
 */
public class Seleccion implements InterfaceMetodo{
    @Override
    public void ordenamiento(int[] arregloint) throws IOException {

        long time_start, time_end;

        time_start = System.currentTimeMillis();

        System.out.println("Inicia ordenamiento por Seleccion..");


        int i, j, k, p, buffer, limit = arregloint.length-1;
        for(k = 0; k < limit; k++)
        {
            p = k;
            for(i = k+1; i <= limit; i++)
                if(arregloint[i] < arregloint[p]) p = i;
            if(p != k)
            {
                buffer = arregloint[p];
                arregloint[p] = arregloint[k];
                arregloint[k] = buffer;
            }
        }

        MetodosArchivoTxt.guardarEnTxt(arregloint);

        time_end = System.currentTimeMillis();

        ConversionTiempo.getTiempoEjecucion(time_end, time_start);


    }
}
