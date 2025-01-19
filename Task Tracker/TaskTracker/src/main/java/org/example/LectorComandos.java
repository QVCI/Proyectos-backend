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

                }
                else
                {
                    if (Comando.contains("task-cli update"))
                    {

                    }
                    else
                    {
                        if (Comando.contains("task-cli delete"))
                        {

                        }
                        else
                        {
                            if (Comando.contains("task-cli mark-in-progress"))
                            {

                            }
                            else
                            {
                                if (Comando.contains("task-cli mark-done"))
                                {

                                }
                                else
                                {
                                    if (Comando.contains("task-cli list"))
                                    {

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

                return 1;
            }

        }



    }
}
