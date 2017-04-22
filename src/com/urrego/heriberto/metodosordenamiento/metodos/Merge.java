package com.urrego.heriberto.metodosordenamiento.metodos;

import com.urrego.heriberto.metodosordenamiento.MetodosArchivoTxt;
import com.urrego.heriberto.metodosordenamiento.ConversionTiempo;

import java.io.IOException;

/**
 * Created by Afuro,Heriberto on 18/04/2017.
 */
public class Merge implements InterfaceMetodo{

    private int[] array;
    private int[] tempMesclaArray;
    private int tamaño;

    @Override
    public void ordenamiento(int[] arregloint) throws IOException {


        long time_start, time_end;

        time_start = System.currentTimeMillis();

        System.out.println("Inicia ordenamiento por Merge..");

        this.array = arregloint;
        this.tamaño = arregloint.length;
        this.tempMesclaArray = new int[tamaño];
        mesclar(0, tamaño - 1);



        MetodosArchivoTxt.guardarEnTxt(arregloint);

        time_end = System.currentTimeMillis();

        ConversionTiempo.getTiempoEjecucion(time_end, time_start);

    }



    private void mesclar(int indiceInferior, int indiceSuperior) {

        if (indiceInferior < indiceSuperior) {
            int medio = indiceInferior + (indiceSuperior - indiceInferior) / 2;

            mesclar(indiceInferior, medio);

            mesclar(medio + 1, indiceSuperior);

            mesclarPartes(indiceInferior, medio, indiceSuperior);
        }
    }
    private void mesclarPartes(int indeceInferior, int medio, int indiceSuperior) {

        for (int i = indeceInferior; i <= indiceSuperior; i++) {
            tempMesclaArray[i] = array[i];
        }
        int i = indeceInferior;
        int j = medio + 1;
        int k = indeceInferior;
        while (i <= medio && j <= indiceSuperior) {
            if (tempMesclaArray[i] <= tempMesclaArray[j]) {
                array[k] = tempMesclaArray[i];
                i++;
            } else {
                array[k] = tempMesclaArray[j];
                j++;
            }
            k++;
        }
        while (i <= medio) {
            array[k] = tempMesclaArray[i];
            k++;
            i++;
        }

    }


}
