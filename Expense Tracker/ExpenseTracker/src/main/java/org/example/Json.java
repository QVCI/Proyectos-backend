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
            System.out.printf("%-20s %-16s %10s %20s\n", "# ID",  "Date", "Description",  "Amount");
            for (int i = 0; i < tareas.length(); i++)
            {
                JSONObject tarea = tareas.getJSONObject(i);
                String id = tarea.getString("ID Gasto");
                String Fecha = tarea.getString("Fecha");
                String Descripcion = tarea.getString("Descripcion");
                String Costo = tarea.getString("Costo");

                System.out.printf("%-20s %-16s %10s %20s\n", id,  Fecha, Descripcion,  Costo);


            }
        }
    }
    public float CostoTotal(String Mes) throws JSONException
    {
        float total = 0;
        JSONArray tareas = LeerGastos();
        for (int i= 0; i < tareas.length(); ++i)
        {
            JSONObject tarea = tareas.getJSONObject(i);
            if (Mes == null)
            {

                total = total + Float.parseFloat(tarea.getString("Costo"));
            }
            else
            {
                String [] Partes = tarea.getString("Fecha").split("-");
                if (Partes[1].equals(Mes))
                {
                    total = total + Float.parseFloat(tarea.getString("Costo"));
                }

            }

        }

        return total;

    }






    // Elimina Tarea
    public void EliminaGato(int NumeroTarea) throws JSONException
    {
        JSONArray tareas = LeerGastos();
        if (NumeroTarea < 1 || NumeroTarea > tareas.length())
        {
            System.out.println("Número de gasto inválido.");
            return;
        }

        String nombreTarea = tareas.getJSONObject(NumeroTarea - 1).getString("Descripcion");
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
