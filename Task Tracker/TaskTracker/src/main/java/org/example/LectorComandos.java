package org.example;


public class LectorComandos
{
    public int Comando(String Comando)
    {
        if (Comando.equals("task-cli stop"))
        {
            return 0;
        }
        else
        {
            if (Comando.equals("task-cli help"))
            {
                System.out.println("--------------------------------Comandos--------------------------------");
                System.out.println("Comandos de Sistema:");
                System.out.println("task-cli stop: Finaliza el proceso de Task Tracker");
                System.out.println("task-cli help: Despliega la lista de comandos");
                System.out.println("");
                System.out.println("Comandos de Uso:");
                System.out.println("task-cli add \"Nombre de tarea\": Despliega la lista de comandos");
                System.out.println("task-cli update ID \"Nombre de tarea\": Actualiza la tarea");
                System.out.println("task-cli delete ID: Elimina la tarea");
                System.out.println("task-cli mark-in-progress ID: Marcar como tarea en proceso");
                System.out.println("task-cli mark-done ID: Marcar como tarea finalizada");
                System.out.println("task-cli list: Enseña todas las tareas");
                System.out.println("task-cli list done: Enseña todas las finalizadas");
                System.out.println("task-cli list in-progress: Enseña todas las tares en proceso");

                System.out.println("-------------------------------------------------------------------------");


                return 1;
            }
            else
            {
                if (Comando.contains("task-cli add"))
                {
                    return 2;
                }
                else
                {
                    if (Comando.contains("task-cli update"))
                    {
                        return 3;
                    }
                    else
                    {
                        if (Comando.contains("task-cli delete"))
                        {
                            return 4;
                        }
                        else
                        {
                            if (Comando.contains("task-cli mark-in-progress"))
                            {
                                return 5;
                            }
                            else
                            {
                                if (Comando.contains("task-cli mark-done"))
                                {
                                    return 6;
                                }
                                else
                                {
                                    if (Comando.contains("task-cli list"))
                                    {
                                        if (Comando.contains("done"))
                                        {
                                            return 7;
                                        }
                                        else
                                        {
                                            if (Comando.contains("in-progress"))
                                            {
                                                return 8;
                                            }
                                            else
                                            {
                                                //retorna todas las listas
                                                return 9;
                                            }
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Comando no valido, escriba \"task-cli help\" para visualizar los comandos validos");
                                        return 1;
                                    }
                                }
                            }
                        }
                    }
                }


            }

        }



    }


    public String Limpiaorden (String Comando)
    {


        if (Comando.contains("task-cli add"))
        {
            Comando.replace("task-cli add", "");
            Comando.replaceAll("\"", "");
        }
        if (Comando.contains("task-cli update"))
        {
            Comando.replace("task-cli update", "");
           // este tiene que hacer algo más
        }
        if (Comando.contains("task-cli delete"))
        {
            Comando.replace("task-cli delete", "");
            Comando.trim();

        }
        if (Comando.contains("task-cli mark-in-progress"))
        {
            Comando.replace("task-cli mark-in-progress", "");
            Comando.trim();
        }
        if (Comando.contains("task-cli mark-done"))
        {
            Comando.replace("task-cli mark-done", "");
            Comando.trim();
        }
        if (Comando.contains("task-cli list"))
        {

        }
        System.out.println(Comando);
        return Comando;

    }
}
