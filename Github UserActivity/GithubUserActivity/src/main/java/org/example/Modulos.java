package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Modulos {
    public void ModuloApagado() {
        System.out.println("Gracias por usar.");
    }

    public void ModuloActividad(String NombreUsuario) {


        if (NombreUsuario.trim().isEmpty()) {
            System.out.println("No se ha detectado un nombre de usuario");
            return;
        }
        String link = "https://api.github.com/users/" + NombreUsuario.trim() + "/events";
        String respuesta = "";

        try {
            respuesta = peticionHttpGet(link);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(respuesta);

            int contadorcommits = 0;

            for (JsonNode eventos: jsonNode)
            {
                JsonNode payload = eventos.get("payload");
                if (payload != null && payload.has("size")) {
                    contadorcommits += payload.get("size").asInt();
                }
            }
            System.out.println("Numero de Commits por " + NombreUsuario.trim() + ": " + contadorcommits);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("El usuario: " + NombreUsuario.trim() + ", no ha sido encontrado");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }



    }

    public static String peticionHttpGet(String link) throws IOException
    {

        StringBuilder resultado = new StringBuilder();
        URL url = new URL(link);

        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;

        while ((linea = rd.readLine()) != null)
        {
            resultado.append(linea);
        }

        rd.close();

        return resultado.toString();


    }

    public String LimpiarComando(String Comando)
    {
        Comando = Comando.replace("github-activity", "");
        Comando = Comando.replace("<", "");
        Comando = Comando.replace(">", "");
        Comando.trim();
        return Comando;
    }
    public void ModuloAyuda()
    {
        System.out.println("------------------------Comandos------------------------");
        System.out.println("github-activity stop: Detiene el sistema");
        System.out.println("github-activity <USER>: Obten la actividad del usuario");
        System.out.println("github-activity help:  Muestra los comandos");
        System.out.println("--------------------------------------------------------");

    }
}
