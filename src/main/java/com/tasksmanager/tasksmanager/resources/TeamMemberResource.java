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
import com.tasksmanager.tasksmanager.entities.TeamMember;
import com.tasksmanager.tasksmanager.repositories.TeamMemberRepository;

@RestController
@RequestMapping(value = "/team-members")
public class TeamMemberResource {

	@Autowired
	private TeamMemberRepository teamMemberRepository;
	
	@GetMapping
	public ResponseEntity<List<TeamMember>> findAll() {
		List<TeamMember> list = teamMemberRepository.findAll();
		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TeamMember> findById(@PathVariable Long id) {
		TeamMember teamMemnber = teamMemberRepository.findById(id).get();
		
		return ResponseEntity.ok().body(teamMemnber);
	}
	
	@RequestMapping(method =  RequestMethod.POST)
    public TeamMember create(@RequestBody TeamMember teamMember)
    {
        return teamMemberRepository.save(teamMember);
    }
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
	public TeamMember update(@PathVariable Long id, @RequestBody TeamMember teamMember) {
		teamMember.setId(id);
		return teamMemberRepository.save(teamMember);
	} 
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		teamMemberRepository.deleteById(id);
	} 
}
