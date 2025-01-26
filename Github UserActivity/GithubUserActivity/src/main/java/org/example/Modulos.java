package org.example;

public class Modulos
{
    public void ModuloApagado()
    {
        System.out.println("Gracias por usar.");
    }
    public void ModuloActividad(String NombreUsuario)
    {

        if (NombreUsuario.trim().isEmpty())
        {
            System.out.println("No se ha detectado un nombre de usuario");
            return;
        }



    }
    public String LimpiarComando(String Comando)
    {
        Comando = Comando.replace("github-activity", "");
        Comando = Comando.replace("<", "");
        Comando = Comando.replace(">", "");
        Comando.trim();
        System.out.println("Nombre: " + Comando);
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
