package com.urrego.heriberto.metodosordenamiento.menu;

import com.urrego.heriberto.metodosordenamiento.MetodosArchivoTxt;
import com.urrego.heriberto.metodosordenamiento.metodos.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Afuro,Heriberto on 19/04/2017.
 */
public abstract class Menu {

    private static int TipodeDato = 0;

    public static void getMenuPrincipal () throws IOException {

        String ruta = "Lista.txt"; //aqui la ruta donde se va a guardar
        File Lista = new File(ruta);

        Scanner sc = new Scanner(System.in);
        String opcion = "";

        while (opcion != "0"){
            System.out.println("[METODOS ORDENAMIENDO - MENU PRINCIPAL]\n\n" +
                    "1.Crear archivo '.txt'.\n" +
                    "2.Llenar archivo '.txt'.");

            if(Lista.exists()) {
                System.out.println("3.ordenar archivo actual '.txt'.");
            }

            System.out.println("0.Salir.");

            opcion = sc.nextLine();

            if (opcion != "0"){
                setMenuPrincipal(opcion);

            }
        }
    }

    public static void setMenuPrincipal (String opcion) throws IOException {

        String ruta = "Lista.txt"; //aqui la ruta donde se va a guardar
        File Lista = new File(ruta);

        switch (opcion){
            case "1"://Crear archivo txt

                BufferedWriter bw;

                if(Lista.exists()) {
                    bw = new BufferedWriter(new FileWriter(Lista));
                    System.out.println("El fichero de texto ya esta creado.\n\n");
                } else {
                    bw = new BufferedWriter(new FileWriter(Lista));
                    System.out.println("Creando el fichero de texto.\n\n");
                }

                bw.close();
                getMenuPrincipal();

                break;

            case "2"://Llenar archivo txt
                MenuTipoInt(Lista);
                break;

            case "3"://ordenar
                if(Lista.exists()) {

                    getMenuMetodoOrfenamiento(Lista);
                    break;

                } else {

                    System.out.println("[ERROR: Ingrese una opción valida.]'\n\n\n\n");
                }

            case "0":
                //Salir del programa txt (este case es vacio)
                break;
            default:

                System.out.println("[ERROR: Ingrese una opción valida.]'\n\n\n\n");
        }

    }

    public static void MenuTipoInt (File Lista) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("[ELIJA TIPO DE ENTEROS]\n\n" +
                "1. Negativos y Positivos.\n" +
                "2. Positivos.");

        try {
            TipodeDato = sc.nextInt();

        }catch (java.util.InputMismatchException ex){
            System.out.println("[ERROR: Ingrese una opcion valida.]\n\n");
        }

        if ((TipodeDato == 1)||(TipodeDato == 2)){
            getMenuTamanoTXT(Lista);
        }else{
            MenuTipoInt(Lista);
        }
    }


    public static void getMenuTamanoTXT (File Lista) throws IOException {

        Scanner sc = new Scanner(System.in);
        String opcion = "";

        System.out.println("[ELIJA TAMAÑO TXT]\n\n" +
                "1.1 Millon de Datos\n" +
                "2.2 Millones de Datos\n" +
                "3.5 Millones de Datos\n" +
                "4.10 Millones de Datos\n" +
                "5.15 Millones de Datos\n" +
                "6.20 Millones de Datos\n" +
                "0.Volver a Inicio.");

        opcion = sc.nextLine();

        setMenuTamanoTXT(opcion, Lista);
    }

    public static void setMenuTamanoTXT (String opcion, File Lista) throws IOException {

        long limite = 0;

        switch (opcion){
            case "1"://1 Millones de Datos
                limite = 1000000;
                break;

            case "2"://2 Millones de Datos
                limite = 2000000;
                break;

            case "3"://5 Millones de Datos
                limite = 5000000;
                break;

            case "4"://10 Millones de Datos
                limite = 10000000;
                break;

            case "5"://15 Millones de Datos
                limite = 15000000;
                break;

            case "6"://20 Millones de Datos
                limite = 20000000;
                break;

            case "0"://volver al inicio del programa
                getMenuPrincipal();
                break;
            default:
                System.out.println("[ERROR: Ingrese una opción valida.]'\n\n\n\n");
        }

        // llenado de archivo
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(Lista));
        int numero;

        for (int i=0; i<= limite; i++){
            Random lista= new Random();

            if (TipodeDato == 2){
                numero = (lista.nextInt(99999) + 1);
            }else {
                numero = (lista.nextInt(199999) - 99999);
            }

            bw.write(numero+" ");
        }
        bw.close();

        getMenuMetodoOrfenamiento(Lista);

    }

    public static void getMenuMetodoOrfenamiento (File Lista) throws IOException {

        Scanner sc = new Scanner(System.in);
        String opcion = "";

        System.out.println("[ELIJA METODO DE ORDENAMIENTO]\n\n" +
                "1.Burbuja\n" +
                "2.Insercion\n" +
                "3.Quick\n" +
                "4.Merge\n" +
                "5.Seleccion\n" +
                "6.Shell\n" +
                "7.Counting\n" +
                "8.Radix\n" +
                "9.Heap\n" +
                "0.Volver a Inicio.");

        opcion = sc.nextLine();

        setMenuMetodoOrfenamiento(opcion, Lista);

    }


    public static void setMenuMetodoOrfenamiento (String opcion, File Lista) throws IOException {

        InterfaceMetodo metodoOrdenamiento;


        switch (opcion){
            case "1"://Burbuja

                metodoOrdenamiento = new Burbuja();
                metodoOrdenamiento.ordenamiento(MetodosArchivoTxt.convertiEnArray(Lista));

                break;

            case "2"://Insercion

                metodoOrdenamiento = new Insercion();
                metodoOrdenamiento.ordenamiento(MetodosArchivoTxt.convertiEnArray(Lista));

                break;

            case "3"://Quick

                metodoOrdenamiento = new Quick();
                metodoOrdenamiento.ordenamiento(MetodosArchivoTxt.convertiEnArray(Lista));

                break;

            case "4"://Merge

                metodoOrdenamiento = new Merge();
                metodoOrdenamiento.ordenamiento(MetodosArchivoTxt.convertiEnArray(Lista));

                break;

            case "5"://Seleccion

                metodoOrdenamiento = new Seleccion();
                metodoOrdenamiento.ordenamiento(MetodosArchivoTxt.convertiEnArray(Lista));

                break;

            case "6"://Shell

                metodoOrdenamiento = new Shell();
                metodoOrdenamiento.ordenamiento(MetodosArchivoTxt.convertiEnArray(Lista));

                break;

            case "7"://Countingsort

                metodoOrdenamiento = new CountingSort();
                metodoOrdenamiento.ordenamiento(MetodosArchivoTxt.convertiEnArray(Lista));

                break;

            case "8"://Radix

                if (TipodeDato == 2){
                    metodoOrdenamiento = new Radix();
                    metodoOrdenamiento.ordenamiento(MetodosArchivoTxt.convertiEnArray(Lista));
                }else{
                    System.out.println("[ERROR: Este metodo solo aplica para listas con enteros positivos.]\n\n");
                }

                break;

            case "9"://Heap

                metodoOrdenamiento = new Heap();
                metodoOrdenamiento.ordenamiento(MetodosArchivoTxt.convertiEnArray(Lista));

                break;

            case "0"://volver al inicio del programa
                getMenuPrincipal();
                break;
            default:
                System.out.println("[ERROR: Ingrese una opción valida.]'\n\n\n\n");
        }

    }

}
