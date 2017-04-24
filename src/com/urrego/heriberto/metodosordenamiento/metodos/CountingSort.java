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


        int N = arregloint.length;
        if (N == 0)
            return;
        /* find max and min values */
        int max = arregloint[0], min = arregloint[0];
        for (int i = 1; i < N; i++)
        {
            if (arregloint[i] > max)
                max = arregloint[i];
            if (arregloint[i] < min)
                min = arregloint[i];
        }
        int range = max - min + 1;

        /* check if range is small enough for count arreglointay */
        /* else it might give out of memory exception while allocating memory for arreglointay */
        if (range > arregloint.length)
        {
            System.out.println("\nError : Range too large for sort");
            return;
        }

        int[] count = new int[range];
        /* make count/frequency arreglointay for each element */
        for (int i = 0; i < N; i++)
            count[arregloint[i] - min]++;
        /* modify count so that positions in final arreglointay is obtained */
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        /* modify original arreglointay */
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arregloint[j++] = i + min;



        MetodosArchivoTxt.guardarEnTxt(arregloint);

        time_end = System.currentTimeMillis();

        ConversionTiempo.getTiempoEjecucion(time_end, time_start);
    }

}