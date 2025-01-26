package org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int opcion = 1;
        String Comando = null;
        Scanner SC = new Scanner(System.in);
        Modulos modulos = new Modulos();
        while (opcion != 0)
        {
            LectorComandos lectorComandos = new LectorComandos();
            Comando= SC.nextLine();
            opcion = lectorComandos.LectorComandos(Comando);
            switch (opcion)
            {
                case 0:
                    modulos.ModuloApagado();
                    break;

                case 1:

                    modulos.ModuloActividad(modulos.LimpiarComando(Comando));
                    break;

                case 2:
                    modulos.ModuloAyuda();
                    break;

                case 3:
                    System.out.println("Comando no reconocido \"github-activity help\", " +
                            "para ver la lista de comandos disponibles");
            }
        }
    }


}