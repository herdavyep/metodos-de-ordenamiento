package com.urrego.heriberto.metodosordenamiento.metodos;

import com.urrego.heriberto.metodosordenamiento.MetodosArchivoTxt;
import com.urrego.heriberto.metodosordenamiento.ConversionTiempo;

import java.io.IOException;

/**
 * Created by Afuro,Heriberto on 18/04/2017.
 */
public class Quick implements InterfaceMetodo{



    private int array[];
    private int tamaño;

    @Override
    public void ordenamiento(int[] arregloint) throws IOException {

        long time_start, time_end;

        time_start = System.currentTimeMillis();

        System.out.println("Inicia ordenamiento por Quick..");

        if (arregloint == null || arregloint.length == 0) {
            return;
        }
        this.array = arregloint;
        tamaño = arregloint.length;
        quickSort(0, tamaño - 1);

        MetodosArchivoTxt.guardarEnTxt(arregloint);

        time_end = System.currentTimeMillis();

        ConversionTiempo.getTiempoEjecucion(time_end, time_start);

    }

    private void quickSort(int indiceInferior, int indiceSuperior) {

        int i = indiceInferior;
        int j = indiceSuperior;
        int pivote = array[indiceInferior+(indiceSuperior -indiceInferior)/2];

        while (i <= j) {

            while (array[i] < pivote) {
                i++;
            }
            while (array[j] > pivote) {
                j--;
            }
            if (i <= j) {
                numerosDeIntercambio(i, j);

                i++;
                j--;
            }
        }
        if (indiceInferior < j)
            quickSort(indiceInferior, j);
        if (i < indiceSuperior)
            quickSort(i, indiceSuperior);
    }

    private void numerosDeIntercambio(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



}
