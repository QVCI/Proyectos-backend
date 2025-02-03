package org.example;

import org.json.JSONException;

public class LectorSistema
{
    public boolean ClasificadorOperacion(String Parte1, String Parte2, String Parte3, String Parte4)
    {

        if (Parte1 == null)
        {
            return false;
        }
        if (Parte1.equals("add"))
        {
            if(Parte2 == null || Parte3 == null || Parte4 == null)
            {
                System.out.println("Comando no valido");
                return false;
            }
            try
            {
                Agregar(Parte2, Parte3, Parte4);
            }
            catch (JSONException e)
            {
                System.out.println("Error");
            }
            return true;
        }
        if (Parte1.equals("list"))
        {
            if(Parte2 == null || Parte3 == null || Parte4 == null)
            {
                System.out.println("Comando no valido");
                return false;
            }

            return true;
        }
        if (Parte1.equals("summary"))
        {
            if( Parte3 != null || Parte4 != null)
            {
                System.out.println("Comando no valido");
                return false;
            }
            return true;
        }
        if (Parte1.equals("delete"))
        {
            if( Parte3 == null || Parte4 == null)
            {
                System.out.println("Comando no valido");
                return false;
            }
            return true;
        }
        return false;
    }

    public void Agregar (String Parte2, String Parte3, String Parte4) throws JSONException
    {
        if (!Parte2.equals("--description") || !Parte4.contains("--amount") || !Parte3.contains("\""))
        {
            System.out.println("Comando no valido");

        }
        else
        {
            Parte3 = Parte3.replace("\"", "").trim();
            Parte4 = Parte4.replace("--amount", "").trim();

            float costo = Float.parseFloat(Parte4);
            Json json = new Json();
            json.AñadeGasto(Parte3.trim(), costo);
        }
    }
    public void Lista() throws JSONException {
        Json json = new Json();
        try
        {
            json.ListaGastos();
        }
        catch (JSONException e)
        {
            throw new RuntimeException(e);
        }
    }
}
