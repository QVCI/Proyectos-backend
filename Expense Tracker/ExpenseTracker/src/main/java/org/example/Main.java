package org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        do
        {
            System.out.println("Bienvenido a Expense Tracker");

            String Comando = "";
            Scanner SC = new Scanner(System.in);
            Comando = SC.nextLine();
            if (!Comando.contains("expense-tracker"))
            {
                System.out.println("Comando no reconocido");
            }
            else
            {
                Comando = Comando.replace("expense-tracker", "").trim();
                String [] Partes = Comando.split(" ");
                String Parte1= null;
                String Parte2= null;
                String Parte3 = null;
                String Parte4= null;

                switch (Partes.length)
                {
                    case 1:
                        Parte1 = Partes[0];
                        break;
                    case 2:
                        Parte1 = Partes[0];
                        Parte2 = Partes[1];
                        break;
                    case 3:
                        Parte1 = Partes[0];
                        Parte2 = Partes[1];
                        Parte3 = Partes[2];
                        break;
                    case 5:
                        Parte1 = Partes[0];
                        Parte2 = Partes[1];
                        Parte3 = Partes[2];
                        Parte4 = Partes[3] + Partes[4];
                        break;
                }
                System.out.println("Parte 1: " + Parte1);
                System.out.println("Parte 2: " + Parte2);
                System.out.println("Parte 3: " + Parte3);
                System.out.println("Parte 4: " + Parte4);
                LectorSistema lectorSistema = new LectorSistema();
                if (!lectorSistema.ClasificadorOperacion(Parte1, Parte2,Parte3,Parte4))
                {

                }




                System.out.println(Comando);
            }


        }
        while (true);
    }
}