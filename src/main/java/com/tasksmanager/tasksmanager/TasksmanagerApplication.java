package com.tasksmanager.tasksmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tasksmanager.tasksmanager.entities.Task;
import com.tasksmanager.tasksmanager.repositories.TaskRepository;

@SpringBootApplication
public class TasksmanagerApplication implements CommandLineRunner{
	
	@Autowired
	private TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(TasksmanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Task task1 = new Task(1l, "description 1");
		Task task2 = new Task(2l, "description 2");
		
		taskRepository.save(task1);
		taskRepository.save(task2);
	}

}
