package com.tasksmanager.tasksmanager.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tasksmanager.tasksmanager.entities.Task;

@Component
public class TaskRepository {
	
	private Map<Long, Task> map = new HashMap<>();

	public void save(Task obj) {
		map.put(obj.getId(), obj);
	}

	public Task findById(Long id) {
		return map.get(id);
	}
	
	public List<Task> findAll() {
		return new ArrayList<Task>(map.values());
	}
}
