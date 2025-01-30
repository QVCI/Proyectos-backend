package org.example;

public class LectorSistema
{
    public boolean ClasificadorOperacion(String Parte1, String Parte2, String Parte3, String Parte4)
    {
        if (Parte1.equals("add"))
        {
            if(Parte2 != null || Parte3 != null || Parte4 != null)
            {
                return false;
            }
            return true;
        }
        if (Parte1.equals("list"))
        {
            if(Parte2 == null || Parte3 == null || Parte4 == null)
            {
                return false;
            }
            return true;
        }
        if (Parte1.equals("summary"))
        {
            if( Parte3 != null || Parte4 != null)
            {
                return false;
            }
            return true;
        }
        if (Parte1.equals("delete"))
        {
            if( Parte3 == null || Parte4 == null)
            {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean Agregar (String Parte2, String Parte3, String Parte4)
    {
        if (!Parte2.equals("--description") || !Parte4.contains("--amount") || !Parte3.contains("\""))
        {
            return false;
        }
        return true;

    }
}
