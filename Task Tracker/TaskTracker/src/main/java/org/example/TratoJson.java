package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TratoJson {
    private static final String NombreArchivo = "Tareas.json";

    // agregar tarea
    public void AñadeTarea(String NombreTarea) throws JSONException
    {

        JSONArray tareas = LeeTareas();
        int nuevoID = tareas.length() + 1;
        JSONObject nuevaTarea = new JSONObject();
        nuevaTarea.put("ID Tarea", nuevoID);
        nuevaTarea.put("Nombre", NombreTarea);
        nuevaTarea.put("Completada", false);

        tareas.put(nuevaTarea);
        guardaTareas(tareas);
        System.out.println("Tarea añadida:");
        System.out.println("ID de Tarea: " + nuevoID);
        System.out.println("Nombre: " +  NombreTarea);

    }

    // Enseña tareas
    private static void ListaTareas(boolean filtrar, String TipoFiltro) throws JSONException
    {
        JSONArray tareas = LeeTareas();
        if (tareas.length() == 0)
        {
            System.out.println("No hay tareas.");
        }
        else
        {
            for (int i = 0; i < tareas.length(); i++)
            {
                if (!filtrar)
                {
                    JSONObject tarea = tareas.getJSONObject(i);
                    String status = tarea.getBoolean("Completada") ? "[Completada]" : "[Pendiente]";
                    System.out.println((i + 1) + ". " + status + " " + tarea.getString("Nombre"));
                }
                else
                {
                    JSONObject tarea = tareas.getJSONObject(i);
                    String status = tarea.getBoolean("Completada") ? "[Completada]" : "[Pendiente]";
                    if (status.equals(TipoFiltro))
                    {
                        System.out.println((i + 1) + ". " + status + " " + tarea.getString("Nombre"));
                    }

                }
            }
        }
    }


    // Marcar completada
    public void CambiarEstadoTarea(int NumeroTarea, boolean estado) throws JSONException {
        JSONArray tareas = LeeTareas();
        if (NumeroTarea < 1 || NumeroTarea > tareas.length()) {
            System.out.println("Número de tarea inválido.");
            return;
        }

        JSONObject tarea = tareas.getJSONObject(NumeroTarea - 1);
        if (tarea.getBoolean("Completada") != estado)
        {
            tarea.put("Completada", estado);
            guardaTareas(tareas);
            if (estado)
            {
                System.out.println("Tarea "+ tarea.getString("Nombre") +", marcada como completada");
            }
            else
            {
                System.out.println("Tarea "+ tarea.getString("Nombre") +", marcada en progreso");
            }
        }
        else
        {
            if (estado)
            {
                System.out.println("La Tarea " + tarea.getString("Nombre") + ", ya ha sido marcada como completada");
            }
            else
            {
                System.out.println("La Tarea " + tarea.getString("Nombre") + ", ya ha sido marcada como en proceso");
            }
        }

    }

    // actualizar Tarea
    public void ActualizarTarea(int NumeroTarea, String NuevoNombre) throws JSONException
    {
        JSONArray tareas = LeeTareas();
        if (NumeroTarea < 1 || NumeroTarea > tareas.length())
        {
            System.out.println("Número de tarea inválido.");
            return;
        }
        JSONObject tarea = tareas.getJSONObject(NumeroTarea - 1);
        String nombreTarea = tareas.getJSONObject(NumeroTarea - 1).getString("Nombre");
        tarea.put("Nombre", NuevoNombre);
        guardaTareas(tareas);

        System.out.println("Nombre de Tarea actualizado:");
        System.out.println("Anterior: " + nombreTarea);
        System.out.println("Nuevo: " + NuevoNombre);
    }

    // Elimina Tarea
    public void EliminarTarea(int NumeroTarea) throws JSONException
    {
        JSONArray tareas = LeeTareas();
        if (NumeroTarea < 1 || NumeroTarea > tareas.length())
        {
            System.out.println("Número de tarea inválido.");
            return;
        }

        String nombreTarea = tareas.getJSONObject(NumeroTarea - 1).getString("Nombre");
        tareas.remove(NumeroTarea - 1);
        guardaTareas(tareas);
        System.out.println("Tarea eliminada: " + nombreTarea);
    }

    // Lee archivo
    private static JSONArray LeeTareas()
    {
        File file = new File(NombreArchivo);
        if (!file.exists())
        {
            return new JSONArray();
        }

        try
        {
            String content = new String(Files.readAllBytes(Paths.get(NombreArchivo)));
            return new JSONArray(content);
        }
        catch (IOException e)
        {
            System.out.println("Error al leer el archivo de tareas: " + e.getMessage());
            return new JSONArray();
        } catch (JSONException e)
        {
            throw new RuntimeException(e);
        }
    }

   //Guarda tareas en archivo
    private static void guardaTareas(JSONArray tareas)
    {
        try (FileWriter file = new FileWriter(NombreArchivo))
        {
            file.write(tareas.toString(4));
        } catch (IOException e)
        {
            System.out.println("Error al escribir el archivo de tareas: " + e.getMessage());
        } catch (JSONException e)
        {
            throw new RuntimeException(e);
        }
    }


}

