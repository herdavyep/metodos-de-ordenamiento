package com.urrego.heriberto.metodosordenamiento.metodos;

import com.urrego.heriberto.metodosordenamiento.MetodosArchivoTxt;
import com.urrego.heriberto.metodosordenamiento.ConversionTiempo;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Afuro,Heriberto on 21/04/17.
 */
public class Radix implements InterfaceMetodo{


    @Override
    public void ordenamiento(int[] arregloint) throws IOException {

        long time_start, time_end;

        time_start = System.currentTimeMillis();

        System.out.println("Inicia ordenamiento por Radix..");

        int n = arregloint.length;
        int m = getMax(arregloint, n);

        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arregloint, n, exp);

        MetodosArchivoTxt.guardarEnTxt(arregloint);

        time_end = System.currentTimeMillis();

        ConversionTiempo.getTiempoEjecucion(time_end, time_start);

    }

    static void countSort(int array[], int n, int exp)
    {
        int salida[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[ (array[i]/exp)%10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--)
        {
            salida[count[ (array[i]/exp)%10 ] - 1] = array[i];
            count[ (array[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++)
            array[i] = salida[i];
    }

    static int getMax(int array[], int n)
    {
        int mx = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > mx)
                mx = array[i];
        return mx;
    }

}

