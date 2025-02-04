package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Json
{
    private static final String NombreArchivo = "Tareas.json";

    // agregar tarea
    public void AñadeGasto(String Descripcion, float costo) throws JSONException
    {

        JSONArray gastos = LeerGastos();
        int nuevoID = gastos.length() + 1;
        JSONObject nuevogasto = new JSONObject();
        nuevogasto.put("ID Gasto", nuevoID);
        nuevogasto.put("Descripcion", Descripcion);
        Date date = new Date();
        String fecha = (new SimpleDateFormat("dd-MM-yyyy")).format(date);

        nuevogasto.put("Fecha",fecha);
        nuevogasto.put("Costo", costo);

        gastos.put(nuevogasto);
        guardaGastos(gastos);
        System.out.println("# Gasto añadido exitosamente (ID: " + nuevoID + ")");

    }

    // Enseña tareas
    public void ListaGastos() throws JSONException
    {
        JSONArray tareas = LeerGastos();
        if (tareas.length() == 0)
        {
            System.out.println("No hay tareas.");
        }
        else
        {
            System.out.printf("%-20s %0s %10s %20s", "# ID",  "Date", "Description",  "Amount");
            for (int i = 0; i < tareas.length(); i++)
            {
                JSONObject tarea = tareas.getJSONObject(i);
                String id = tarea.getString("ID Gasto");
                String Fecha = tarea.getString("Fecha");
                String Descripcion = tarea.getString("Descripcion");
                String Costo = tarea.getString("Costo");

                System.out.printf("%-20s %0s %10s %20s", id,  Fecha, Descripcion,  Costo);


            }
        }
    }


    // Marcar completada
    public void CambiarEstadoTarea(int NumeroTarea, boolean estado) throws JSONException {
        JSONArray tareas = LeerGastos();
        if (NumeroTarea < 1 || NumeroTarea > tareas.length()) {
            System.out.println("Número de tarea inválido.");
            return;
        }

        JSONObject tarea = tareas.getJSONObject(NumeroTarea - 1);
        if (tarea.getBoolean("Completada") != estado)
        {
            tarea.put("Completada", estado);
            guardaGastos(tareas);
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
        JSONArray tareas = LeerGastos();
        if (NumeroTarea < 1 || NumeroTarea > tareas.length())
        {
            System.out.println("Número de tarea inválido.");
            return;
        }
        JSONObject tarea = tareas.getJSONObject(NumeroTarea - 1);
        String nombreTarea = tareas.getJSONObject(NumeroTarea - 1).getString("Nombre");
        tarea.put("Nombre", NuevoNombre);
        guardaGastos(tareas);

        System.out.println("Nombre de Tarea actualizado:");
        System.out.println("Anterior: " + nombreTarea);
        System.out.println("Nuevo: " + NuevoNombre);
    }

    // Elimina Tarea
    public void EliminarTarea(int NumeroTarea) throws JSONException
    {
        JSONArray tareas = LeerGastos();
        if (NumeroTarea < 1 || NumeroTarea > tareas.length())
        {
            System.out.println("Número de tarea inválido.");
            return;
        }

        String nombreTarea = tareas.getJSONObject(NumeroTarea - 1).getString("Nombre");
        tareas.remove(NumeroTarea - 1);
        guardaGastos(tareas);
        System.out.println("Tarea eliminada: " + nombreTarea);
    }

    // Lee archivo
    private static JSONArray LeerGastos()
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
            System.out.println("Error al leer el gastos de tareas: " + e.getMessage());
            return new JSONArray();
        } catch (JSONException e)
        {
            throw new RuntimeException(e);
        }
    }

    //Guarda tareas en archivo
    private static void guardaGastos(JSONArray tareas)
    {
        try (FileWriter file = new FileWriter(NombreArchivo))
        {
            file.write(tareas.toString(4));
        } catch (IOException e)
        {
            System.out.println("Error al escribir el archivo de gastos: " + e.getMessage());
        } catch (JSONException e)
        {
            throw new RuntimeException(e);
        }
    }


}
