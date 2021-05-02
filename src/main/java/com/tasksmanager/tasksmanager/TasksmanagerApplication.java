package com.tasksmanager.tasksmanager;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tasksmanager.tasksmanager.entities.Task;
import com.tasksmanager.tasksmanager.entities.TeamMember;
import com.tasksmanager.tasksmanager.repositories.TaskRepository;
import com.tasksmanager.tasksmanager.repositories.TeamMemberRepository;

@SpringBootApplication
public class TasksmanagerApplication implements CommandLineRunner{
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TeamMemberRepository teamMemberRepository;

	public static void main(String[] args) {
		SpringApplication.run(TasksmanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TeamMember teamMember1 = new TeamMember(null, "Lucas", "lucas@email.com", "123", "Desenvolvedor(a) FullStack");
		TeamMember teamMember2 = new TeamMember(null, "Maria", "maria@email.com", "123", "UX/UI Design");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();
	    String formatedDate = formatter.format(date);
		
	    Task task1 = new Task(null, teamMember1, "description teste 1", formatedDate);
		Task task2 = new Task(null, teamMember1, "description teste 2", formatedDate);
		Task task3 = new Task(null, teamMember2, "description teste 3", formatedDate);
		Task task4 = new Task(null, teamMember2, "description teste 4", formatedDate);
		
		teamMember1.setTasks(Arrays.asList(task1, task2));
		teamMember2.setTasks(Arrays.asList(task3, task4));
		
		teamMemberRepository.save(teamMember1);
		teamMemberRepository.save(teamMember2);
		
		taskRepository.save(task1);
		taskRepository.save(task2);
		taskRepository.save(task3);
		taskRepository.save(task4);
	}

}
