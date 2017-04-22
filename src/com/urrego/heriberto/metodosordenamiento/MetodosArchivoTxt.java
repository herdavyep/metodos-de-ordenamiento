package com.urrego.heriberto.metodosordenamiento;

import java.io.*;

/**
 * Created by Afuro,Heriberto on 20/04/2017.
 */
public class MetodosArchivoTxt {

    public static int[] convertiEnArray (File Lista) throws IOException {

        FileReader fr = new FileReader(Lista);
        BufferedReader buffer = new BufferedReader(fr);

        String temp ="";
        String[] arreglo;
        temp = buffer.readLine();
        String x = temp;
        int[] arregloint;

        try{

            arreglo = x.split(" ");
            arregloint = new int[arreglo.length];


            for(int i=0; i<arreglo.length; i++){
                arregloint[i] = Integer.parseInt(arreglo[i]);
                //System.out.println(arreglo[i]);
            }

            return arregloint;

        }catch (NullPointerException e){

            arregloint = new int[1];
            //arregloint[0] = 0;

        }

        return arregloint;
    }

    public static void guardarEnTxt (int[] arregloint) throws IOException {

        String ruta = "ListaOrdenada.txt"; //aqui la ruta donde se va a guardar

        File Lista = new File(ruta);
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(Lista));

        for (int i=0; i< arregloint.length; i++){
            int numero = arregloint[i];
            bw.write(numero+" ");
        }
        bw.close();

    }
}
