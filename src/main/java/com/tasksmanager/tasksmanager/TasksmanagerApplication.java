package com.tasksmanager.tasksmanager;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tasksmanager.tasksmanager.domain.enums.Profile;
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
		TeamMember teamMember1Admin = new TeamMember(null, "Admin", "admin@email.com", "123", "Desenvolvedor(a) FullStack");
		teamMember1Admin.addProfile(Profile.ADMIN);
		
		TeamMember teamMember1 = new TeamMember(null, "Lucas Santos", "lucas@email.com", "123", "Desenvolvedor(a) FullStack");
		TeamMember teamMember2 = new TeamMember(null, "Maria Aparecida", "maria@email.com", "123", "UX/UI Design");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();
	    String formatedDate = formatter.format(date);
		
	    Task task1 = new Task(null, teamMember1, "Revisar implementação da Sprint anterior", formatedDate);
		Task task2 = new Task(null, teamMember1, "Implementar nova funcionalidade do sistema", formatedDate);
		Task task3 = new Task(null, teamMember2, "Realizar a entrevista com usuários do novo sistema", formatedDate);
		Task task4 = new Task(null, teamMember2, "Desenvolver protótipo de tela do novo sistema", formatedDate);
		Task task5 = new Task(null, teamMember1, "Corrigir erro ao salvar formulário", formatedDate);
		Task task6 = new Task(null, teamMember1, "Refatorar código já implementado", formatedDate);
		Task task7 = new Task(null, teamMember2, "Atualizar licensa do software", formatedDate);
		Task task8 = new Task(null, teamMember2, "Preparar apresentação PPT para o cliente", formatedDate);
		
		teamMember1.setTasks(Arrays.asList(task1, task2, task5, task6));
		teamMember2.setTasks(Arrays.asList(task3, task4, task7, task8));
	
		teamMemberRepository.save(teamMember1Admin);
		teamMemberRepository.save(teamMember1);
		teamMemberRepository.save(teamMember2);
		
		taskRepository.save(task1);
		taskRepository.save(task2);
		taskRepository.save(task3);
		taskRepository.save(task4);
		taskRepository.save(task5);
		taskRepository.save(task6);
		taskRepository.save(task7);
		taskRepository.save(task8);
	}

}
