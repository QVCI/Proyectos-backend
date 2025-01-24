package org.example;

import org.json.JSONException;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws JSONException {

        int opcion = 1;
        Scanner SC = new Scanner(System.in);
        String Comando = null;

        System.out.println("Hola bienvenido a Task Tracker");
        while(opcion != 0)
        {


            LectorComandos lectorComandos = new LectorComandos();
            Comando = SC.nextLine();
            opcion = lectorComandos.Comando(Comando);
            TratoJson tratoJson = new TratoJson();
            switch (opcion) {
                case 2:
                    //añadir
                    if (!lectorComandos.Limpiaorden(Comando).trim().isEmpty())
                    {
                        tratoJson.AñadeTarea(lectorComandos.Limpiaorden(Comando));

                    }
                    else
                    {
                        System.out.println("Las tareas deben tener un nombre");
                    }
                    break;

                // Actualizar tarea
                case 3:

                    String comando = lectorComandos.Limpiaorden(Comando);
                    if (comando == null || comando.isEmpty()) {
                        System.out.println("El comando no puede estar vacío.");
                        break;
                    }


                    String[] partes = comando.split(" ", 2);
                    if (partes.length < 2)
                    {
                        System.out.println("task-cli help: Despliega la lista de comandos");
                        break;
                    }

                    String numtarea = partes[0].trim();
                    String nombretarea = partes[1].trim();

                    try
                    {
                        int numerotarea = Integer.parseInt(numtarea);

                        if (nombretarea.isEmpty())
                        {
                            System.out.println("El nombre de la tarea no puede estar vacío.");
                        }
                        else
                        {
                            tratoJson.ActualizarTarea(numerotarea, nombretarea);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("El ID debe componerse solo de números.");
                    }
                    catch (JSONException e)
                    {
                        System.out.println("Error procesando JSON: " + e.getMessage());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Ocurrió un error inesperado: " + e);
                    }
                    break;


                case 4:
                    //borrar
                    try
                    {
                        int numerotarea = Integer.parseInt(lectorComandos.Limpiaorden(Comando));
                        tratoJson.EliminarTarea(numerotarea);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("El ID debe componerse solo de números.");
                    }
                    break;

                case 5:
                    //marcar en progreso
                    try
                    {
                        tratoJson.CambiarEstadoTarea(Integer.parseInt(lectorComandos.Limpiaorden(Comando)), false);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("El ID debe componerse solo de números." + e);
                    }
                    break;

                case 6:
                    //marcar finalizado
                    try
                    {
                        tratoJson.CambiarEstadoTarea(Integer.parseInt(lectorComandos.Limpiaorden(Comando)), true);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("El ID debe componerse solo de números.");
                    }
                    break;

                case 7:
                    //enseña tareas hechas
                    tratoJson.ListaTareas(true, "[Completada]");
                    break;

                case 8:
                    //enseña tareas en proceso
                    tratoJson.ListaTareas(true, "[Pendiente]");
                    break;

                case 9:
                    //enseña todas las tareas
                    tratoJson.ListaTareas(false, null);
                    break;
            }



        }
        SC.close();
        System.out.println("Gracias por usar Task Tracker");


    }
}