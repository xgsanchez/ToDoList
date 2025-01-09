package com.example.demo;

import com.example.demo.models.Task;
import com.example.demo.service.TaskServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

		Task task1 = new Task("carro", "de tipo transporte", LocalTime.now());
		Task task2 = new Task("cozinha", "de tipo comida", LocalTime.now());
		Task task3 = new Task("lavar", "de tipo lavar", LocalTime.now());
		Task task4 = new Task("estudar", "de tipo estudar", LocalTime.now());

		System.out.println("*****Guardando Tasks *****");
//		taskService.saveTask(task1);
		System.out.println(task1.getName() + " guardado con exito!");

		List<Task> tasks = new ArrayList<>();
		tasks.add(task2);
		tasks.add(task3);
		tasks.add(task4);
		System.out.println("*****Guardando Tasks *****");

//		Metodo por referencia
//		tasks.forEach(taskService::saveTask);
//		for (int i = 0; i < tasks.size(); i++) {
//			taskService.saveTask(tasks.get(i));
//		}

//		for (Task tas : tasks){
//			taskService.saveTask(tas);
//			System.out.println(tas.getName() + " guardado con exito!");
//		}

		System.out.println("*****Da Tasks *****");

		List<Task> portletTasks = taskService.getAllTask();
		portletTasks.forEach(task -> System.out.println(task.toString()));


		System.out.println("*****Borrando Tasks *****");

		taskService.deleteTaskById(3L);


//		Task tt = taskService.getTaskById(2L);
//		System.out.println(tt);

		List<Task> portletTasks1 = taskService.getAllTask();
		portletTasks1.forEach(task -> System.out.println(task.toString()));
	}
}
