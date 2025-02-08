package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Bienvendo a adivina el número");
        Scanner SC = new Scanner(System.in);
        int opcion = 0;
        do
        {
            Instrucciones();
            try
            {
                opcion = SC.nextInt();
                if (opcion >= 1 && opcion <= 4)
                {
                    if (opcion != 4)
                    {
                       Juego juego = new Juego();
                       juego.Iniciar(opcion);
                    }
                    else
                    {
                        break;
                    }

                }
                else
                {
                    System.out.println("Ingrese un número entre \"1\" y \"4\"");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("La opción debe ser un número.");
                SC.next();
            }



        }while (opcion != 4);
        System.out.println("Gracias por jugar");
    }

    public static void Instrucciones()
    {
        System.out.println("Estoy pensando en un número entre 1 y 100");
        System.out.println("Por cada número adivinado obtendrás 2 vidas más");
        System.out.println("");
        System.out.println("Escoge el nivel de dificultad:");
        System.out.printf("%1s %14s %24s\n", "Opción", "Dificultad", "Intentos disponibles");
        System.out.printf("%4s %14s %20s\n", "1", "Fácil", "10 intentos");
        System.out.printf("%4s %14s %20s\n", "2", "Medio", "5 intentos");
        System.out.printf("%4s %15s %19s\n", "3", "Difícil", "3 intentos");
        System.out.println("");
        System.out.println("Presione 4, para salir");
    }
}