package com.tasksmanager.tasksmanager.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.tasksmanager.entities.Task;
import com.tasksmanager.tasksmanager.repositories.TaskRepository;
import com.tasksmanager.tasksmanager.repositories.TeamMemberRepository;

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
		Task task = taskRepository.findById(id).get();
		
		return ResponseEntity.ok().body(task);
	} 
	
	@RequestMapping(method =  RequestMethod.POST)
    public Task Post(@RequestBody Task task)
    {
        return taskRepository.save(task);
    }
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
	public Task update(@PathVariable Long id, @RequestBody Task task) {
		task.setId(id);
		return taskRepository.save(task);
	} 
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		taskRepository.deleteById(id);
	} 
}
