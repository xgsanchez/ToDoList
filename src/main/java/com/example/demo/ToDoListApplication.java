package com.example.demo;

import com.example.demo.models.Task;
import com.example.demo.service.TaskServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ToDoListApplication  implements CommandLineRunner {

	private final TaskServiceImpl taskService;

    public ToDoListApplication(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}




	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		String answer;
		final String si = "si";

		System.out.println("\n*****Bienvenido al sistema de tareas*****");

		System.out.println("\nPrecione enter para ver el menu de opciones");
		scanner.nextLine();




		 do {
			 System.out.println("Menu de opciones:" +
					 "\n\t1- Vizualizar todas las tareas." +
					 "\n\t2- Crear una nueva tarea." +
					 "\n\t3- Elimar una tarea." +
					 "\n\t4- Retribuir una tarea." +
					 "\n\t5- Ver tarea pendiente." +
					 "\n\t6- Salir del programa.");

			 System.out.println("Que desea realizar");

			 int eleccion = scanner.nextInt();
			 scanner.nextLine();

			 switch (eleccion){
				 case 1:
					 System.out.println("***** listado de tareas *****\n");
					 taskService.getAllTask().forEach(task -> System.out.println(task.toString())); break;

				 case 2:
					 System.out.println("Nombre de la tarea:");
					 String name = scanner.nextLine();
					 System.out.println("Descripcion de la tarea:");
					 String description = scanner.nextLine();

					 Task tarea = new Task(name, description, LocalTime.now(), false);
					 taskService.saveTask(tarea);
					 System.out.println("tarea guardada con exito.");break;

				 case 3: System.out.println("digite el Id de la tarea que desea eliminar");
					 taskService.deleteTaskById(scanner.nextLong());
					 System.out.println("Tarea eliminada con exito"); break;

				 case 4:
					 System.out.println("Digite el id de la tarea que desea ver");
					 Task tareaEliminada = taskService.getTaskById(scanner.nextLong());
					 System.out.println(tareaEliminada.toString());break;

				 case 5:
					 System.out.println("Tareas pendientes");
					 taskService.getTaskNotComplete().forEach(task -> System.out.println(task.toString()));break;


				 case 6: System.exit(0);break;

			 }

			 System.out.println("escriba 'si' si desea realizar otra operacion");

			 answer = scanner.nextLine();

		 } while (answer.equals(si));

		scanner.close();


	}
}
