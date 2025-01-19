# [Task Tracker](https://roadmap.sh/projects/task-tracker)
Task tracker es un proyecto que se utiliza para realizar un seguimiento y administrar sus tareas. En esta tarea, creará una interfaz de línea de comandos (CLI) simple para realizar un seguimiento de lo que necesita hacer, lo que ha hecho y en qué está trabajando actualmente. Este proyecto lo ayudará a practicar sus habilidades de programación, incluido el trabajo con el sistema de archivos, el manejo de entradas de usuario y la creación de una aplicación CLI simple.

## Requisitos
La aplicación debe ejecutarse desde la línea de comandos, aceptar las acciones y entradas del usuario como argumentos y almacenar las tareas en un archivo JSON. El usuario debe poder:

Agregar, actualizar y eliminar tareas
- Marcar una tarea como en progreso o realizada
- Listar todas las tareas
- Enumere todas las tareas que se realizan
- Enumere todas las tareas que no se han realizado
- Enumere todas las tareas que están en curso

A continuación se presentan algunas restricciones para guiar la implementación:

- Puedes utilizar cualquier lenguaje de programación para construir este proyecto.
- Utilice argumentos posicionales en la línea de comandos para aceptar entradas del usuario.
- Utilice un archivo JSON para almacenar las tareas en el directorio actual.
- Se debe crear el archivo JSON si no existe.
- Utilice el módulo del sistema de archivos nativo de su lenguaje de programación para interactuar con el archivo JSON.
- No utilice ninguna biblioteca o marco externo para crear este proyecto.
- Asegúrese de manejar los errores y casos extremos con elegancia.

## Ejemplo
A continuación se muestra la lista de comandos y su uso:

#Adding a new task
task-cli add "Buy groceries"
#Output: Task added successfully (ID: 1)

#Updating and deleting tasks
task-cli update 1 "Buy groceries and cook dinner"
task-cli delete 1

#Marking a task as in progress or done
task-cli mark-in-progress 1
task-cli mark-done 1

#Listing all tasks
task-cli list

#Listing tasks by status
task-cli list done
task-cli list todo
task-cli list in-progress

## Propiedades de la tarea
Cada tarea debe tener las siguientes propiedades:

- id:Un identificador único para la tarea
- description:Una breve descripción de la tarea
- status:El estado de la tarea ( todo, in-progress, done)
- createdAt:La fecha y hora en que se creó la tarea.
- updatedAt:La fecha y hora en que se actualizó la tarea por última vez

Asegúrese de agregar estas propiedades al archivo JSON al agregar una nueva tarea y actualizarlas al actualizar una tarea.

## Empezando
A continuación se muestran algunos pasos que le ayudarán a comenzar con el proyecto CLI de Task Tracker:

### Configurar su entorno de desarrollo
- Elija un lenguaje de programación con el que se sienta cómodo (por ejemplo, Python, JavaScript, etc.).
- Asegúrese de tener un editor de código o IDE instalado (por ejemplo, VSCode, PyCharm).
### Inicialización del proyecto
- Cree un nuevo directorio de proyecto para su CLI de Task Tracker.
- Inicialice un sistema de control de versiones (por ejemplo, Git) para administrar su proyecto.
### Implementación de funciones
- Comience por crear una estructura CLI básica para manejar las entradas del usuario.
- Implemente cada característica una por una, asegurándose de probarla exhaustivamente antes de pasar a la siguiente, por ejemplo implementar primero la funcionalidad de agregar tareas, luego enumerar, luego actualizar, marcar como en progreso, etc.
### Pruebas y depuración
- Pruebe cada función individualmente para asegurarse de que funcione como se espera. Observe el archivo JSON para verificar que las tareas se estén almacenando correctamente.
- Depure cualquier problema que surja durante el desarrollo.
### Finalizando el proyecto
- Asegúrese de que todas las funciones estén implementadas y probadas.
- Limpia tu código y agrega comentarios donde sea necesario.
- Escriba un buen archivo Léame sobre cómo utilizar la CLI de Task Tracker.

Al finalizar este proyecto, habrá desarrollado una herramienta práctica que puede ayudarlo a usted o a otros a administrar tareas de manera eficiente. Este proyecto sienta una base sólida para proyectos de programación más avanzados y aplicaciones del mundo real.

¡Feliz codificación!
