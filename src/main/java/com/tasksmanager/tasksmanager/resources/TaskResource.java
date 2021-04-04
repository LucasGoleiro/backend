package com.tasksmanager.tasksmanager.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.tasksmanager.entities.Task;
import com.tasksmanager.tasksmanager.repositories.TaskRepository;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll() {
		List<Task> list = taskRepository.findAll();
		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id) {
		Task task = taskRepository.findById(id);
		
		return ResponseEntity.ok().body(task);
	} 
}
