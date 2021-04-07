package com.tasksmanager.tasksmanager.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.tasksmanager.entities.TeamMember;
import com.tasksmanager.tasksmanager.repositories.TeamMemberRepository;

@RestController
@RequestMapping(value = "/team-members")
public class TeamMemberResource {

	@Autowired
	private TeamMemberRepository taskRepository;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<TeamMember>> findAll() {
		List<TeamMember> list = taskRepository.findAll();
		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TeamMember> findById(@PathVariable Long id) {
		TeamMember task = taskRepository.findById(id).get();
		
		return ResponseEntity.ok().body(task);
	} 
}
