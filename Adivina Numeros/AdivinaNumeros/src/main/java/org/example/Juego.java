package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Juego
{
    private Random random;
    private Scanner SC;
    private Estadisticas estadisticas;
    private int numero;
    private int intentosenpregunta = 0;

    public Juego()
    {
        this.estadisticas = new Estadisticas();
        this.SC = new Scanner(System.in);
        this.random = new Random();
    }

    public void Iniciar (int Nivel)
    {

        switch (Nivel)
        {
            case 1:
                estadisticas.setVidas(10);
                break;
            case 2:
                estadisticas.setVidas(5);
                break;
            case 3:
                estadisticas.setVidas(3);
                break;
        }
        CreaNuevoJuego();


    }
    public void TerminaJuego()
    {
        System.out.printf("%1s %18s\n", "Número de Aciertos", "Número de Errores");


        System.out.printf("%1s %18s\n", estadisticas.getAciertos(), estadisticas.getIntentos());


    }
    public void Acierto ()
    {
        //aumenta en 2 las vidas
        estadisticas.setVidas(estadisticas.getVidas() + 2);
        estadisticas.setAciertos(estadisticas.getAciertos() + 1);
        System.out.println("Vidas restantes:" + estadisticas.getVidas());
        intentosenpregunta = 0;
        CreaNuevoJuego();
    }
    public String Error(int numero)
    {
        intentosenpregunta++;
        estadisticas.setIntentos(estadisticas.getIntentos() + 1);
        estadisticas.setVidas(estadisticas.getVidas() - 1);
        System.out.println("Vidas restantes:" + estadisticas.getVidas());
        String pistaextra = "";
        if (intentosenpregunta > 1)
        {
            if (numero % 2 == 0)
            {
                pistaextra = " y es par";
            }
            else
            {
                pistaextra = " y es impar";
            }
        }

        return numero > 50 ? "El número está arriba de 50" + pistaextra :"El número está abajo de 50" + pistaextra;


    }
    public void CreaNuevoJuego()
    {
        try
        {
            numero = random.nextInt(100) + 1;
            System.out.println("el numero aleatorio es: " + numero);

            while (estadisticas.getVidas() > 0)
            {
                if (SC.nextInt() != numero)
                {
                    System.out.println(Error(numero));
                    if (estadisticas.getVidas() == 0)
                    {
                        break;
                    }
                }
                else
                {
                    Acierto();
                    break;
                }
            }
            TerminaJuego();
        }
        catch (InputMismatchException e)
        {
            System.out.println("La opción seleccionada, debe ser un número");
            SC.next();
            CreaNuevoJuego();

        }

    }

}
