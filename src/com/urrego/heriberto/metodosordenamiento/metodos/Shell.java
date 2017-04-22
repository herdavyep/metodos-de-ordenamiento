package com.urrego.heriberto.metodosordenamiento.metodos;

import com.urrego.heriberto.metodosordenamiento.MetodosArchivoTxt;
import com.urrego.heriberto.metodosordenamiento.ConversionTiempo;

import java.io.IOException;

/**
 * Created by Afuro,Heriberto on 18/04/2017.
 */
public class Shell implements InterfaceMetodo{
    @Override
    public void ordenamiento(int[] arregloint) throws IOException {

        long time_start, time_end;

        time_start = System.currentTimeMillis();

        System.out.println("Inicia ordenamiento por Shell..");


        for ( int increment = arregloint.length / 2; increment > 0; increment =
                (increment == 2 ? 1 : (int) Math.round(increment / 2.2)))
        {
            for (int i = increment; i < arregloint.length; i++)
            {
                for (int j = i; j >= increment && arregloint[j - increment] >
                        arregloint[j]; j -= increment)
                {
                    int temp = arregloint[j];
                    arregloint[j] =arregloint[j - increment];
                    arregloint[j - increment] = temp;
                }
            }
        }

        MetodosArchivoTxt.guardarEnTxt(arregloint);

        time_end = System.currentTimeMillis();

        ConversionTiempo.getTiempoEjecucion(time_end, time_start);

    }
}
