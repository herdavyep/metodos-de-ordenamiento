package com.urrego.heriberto.metodosordenamiento.metodos;

import com.urrego.heriberto.metodosordenamiento.MetodosArchivoTxt;
import com.urrego.heriberto.metodosordenamiento.ConversionTiempo;

import java.io.IOException;

/**
 * Created by Afuro,Heriberto on 20/04/17.
 */
public class Heap implements InterfaceMetodo{

    private static int N;

    @Override
    public void ordenamiento(int[] arregloint) throws IOException {

        long time_start, time_end;

        time_start = System.currentTimeMillis();

        System.out.println("Inicia ordenamiento por Heap..");


        heapify(arregloint);
        for (int i = N; i > 0; i--)
        {
            swap(arregloint,0, i);
            N = N-1;
            maxheap(arregloint, 0);
        }


        MetodosArchivoTxt.guardarEnTxt(arregloint);

        time_end = System.currentTimeMillis();

        ConversionTiempo.getTiempoEjecucion(time_end, time_start);
    }

    /* Function to build a heap */
    public static void heapify(int arregloint[])
    {
        N = arregloint.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arregloint, i);
    }
    /* Function to swap largest element in heap */
    public static void maxheap(int arregloint[], int i)
    {
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arregloint[left] > arregloint[i])
            max = left;
        if (right <= N && arregloint[right] > arregloint[max])
            max = right;

        if (max != i)
        {
            swap(arregloint, i, max);
            maxheap(arregloint, max);
        }
    }
    /* Function to swap two numbers in an arreglointay */
    public static void swap(int arregloint[], int i, int j)
    {
        int tmp = arregloint[i];
        arregloint[i] = arregloint[j];
        arregloint[j] = tmp;
    }

}
