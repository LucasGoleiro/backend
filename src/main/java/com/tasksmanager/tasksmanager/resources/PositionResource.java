package com.tasksmanager.tasksmanager.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.tasksmanager.entities.Position;
import com.tasksmanager.tasksmanager.repositories.PositionRepository;

@RestController
@RequestMapping(value = "/positions")
public class PositionResource {
	
	@Autowired
	PositionRepository positionRepository;
	
	@GetMapping
	public ResponseEntity<List<Position>> findAll() {
		List<Position> list = positionRepository.findAll();
		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Position> findById(@PathVariable Long id) {
		Position position = positionRepository.findById(id).get();
		
		return ResponseEntity.ok().body(position);
	} 
	
	@RequestMapping(method =  RequestMethod.POST)
    public Position Post(@RequestBody Position position)
    {
        return positionRepository.save(position);
    }
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
	public Position update(@PathVariable Long id, @RequestBody Position position) {
		position.setId(id);
		return positionRepository.save(position);
	} 
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		positionRepository.deleteById(id);
	} 

}
