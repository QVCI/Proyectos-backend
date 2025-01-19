package org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        int opcion = 1;
        Scanner SC = new Scanner(System.in);

        System.out.println("Hola bienvenido a Task Tracker");
        while(opcion != 0)
        {


            LectorComandos lectorComandos = new LectorComandos();

            opcion = lectorComandos.Comando(SC.nextLine());



        }
        SC.close();
        System.out.println("Gracias por usar Task Tracker");


    }
}