package org.example;

public class LectorComandos
{
    public int LectorComandos (String Comando)
    {
        if (Comando.equals("github-activity stop"))
        {
            return 0;
        }
        if (Comando.contains("github-activity"))
        {
            return 1;
        }
        if (Comando.equals("github-activity help"))
        {
            return 2;
        }

        return 3;

    }
}
