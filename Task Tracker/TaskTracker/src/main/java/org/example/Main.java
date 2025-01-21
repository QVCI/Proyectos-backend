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
            switch (opcion)
            {
                case 2:
                    //añadir
                    break;

                case 3:
                    //actualizar
                    break;

                case 4:
                    //borrar
                    break;

                case 5:
                    //marcar en progreso
                    break;

                case 6:
                    //marcar finalizado
                    break;

                case 7:
                    //enseña tareas hechas
                    break;

                case 8:
                    //enseña tareas en proceso
                    break;

                case 9:
                    //enseña todas las tareas
                    break;
            }



        }
        SC.close();
        System.out.println("Gracias por usar Task Tracker");


    }
}