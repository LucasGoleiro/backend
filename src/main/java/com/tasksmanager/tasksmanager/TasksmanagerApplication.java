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
import com.tasksmanager.tasksmanager.entities.Position;
import com.tasksmanager.tasksmanager.entities.Task;
import com.tasksmanager.tasksmanager.entities.TeamMember;
import com.tasksmanager.tasksmanager.repositories.PositionRepository;
import com.tasksmanager.tasksmanager.repositories.TaskRepository;
import com.tasksmanager.tasksmanager.repositories.TeamMemberRepository;

@SpringBootApplication
public class TasksmanagerApplication implements CommandLineRunner{
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TeamMemberRepository teamMemberRepository;
	
	@Autowired
	private PositionRepository positionRepository;

	public static void main(String[] args) {
		SpringApplication.run(TasksmanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Position position1 = new Position(null, "Admin");
		Position position2 = new Position(null, "Gerente");
		Position position3 = new Position(null, "Operador");
		
		TeamMember teamMemberAdmin = new TeamMember(null, "admin", "admin@email.com", "123", position1);
		teamMemberAdmin.addProfile(Profile.ADMIN);
		
		TeamMember teamMember1 = new TeamMember(null, "Lucas Coelho", "lucas@email.com", "123", position2);
		TeamMember teamMember2 = new TeamMember(null, "Henrique Lima", "henrique@email.com", "123", position3);
		TeamMember teamMember3 = new TeamMember(null, "João Vitor", "joao@email.com", "123", position3);
		
		/*
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();
	    String formatedDate = formatter.format(date);
		*/
		
	    /*
	    Task task1 = new Task(null, teamMember1, "Conferir relatório", formatedDate);
		Task task2 = new Task(null, teamMember1, "Realizar entrevista técnica", formatedDate);
		Task task3 = new Task(null, teamMember2, "Conferir estoque", formatedDate);
		Task task4 = new Task(null, teamMember2, "Receber mercadorias", formatedDate);
		Task task5 = new Task(null, teamMember1, "Corrigir erro na planilha", formatedDate);
		Task task6 = new Task(null, teamMember1, "Reportar resultados a central", formatedDate);
		Task task7 = new Task(null, teamMember2, "Atualizar planilha", formatedDate);
		Task task8 = new Task(null, teamMember2, "Acompanhar novo funcionário", formatedDate);
		Task task9 = new Task(null, teamMember3, "Preparar apresentação PPT para o cliente", formatedDate);
		Task task10 = new Task(null, teamMember3, "Enviar email para gerencia", formatedDate);
		/*
		
		/*
		teamMember1.setTasks(Arrays.asList(task1, task2, task5, task6));
		teamMember2.setTasks(Arrays.asList(task3, task4, task7, task8));
		teamMember3.setTasks(Arrays.asList(task9, task10));
		*/
		
		positionRepository.save(position1);
		positionRepository.save(position2);
		positionRepository.save(position3);
	
		teamMemberRepository.save(teamMemberAdmin);
		teamMemberRepository.save(teamMember1);
		teamMemberRepository.save(teamMember2);
		teamMemberRepository.save(teamMember3);
		
		/*
		taskRepository.save(task1);
		taskRepository.save(task2);
		taskRepository.save(task3);
		taskRepository.save(task4);
		taskRepository.save(task5);
		taskRepository.save(task6);
		taskRepository.save(task7);
		taskRepository.save(task8);
		taskRepository.save(task9);
		taskRepository.save(task10);
		*/
	}

}
