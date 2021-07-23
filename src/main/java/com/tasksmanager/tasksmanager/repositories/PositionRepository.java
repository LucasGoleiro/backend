package com.tasksmanager.tasksmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasksmanager.tasksmanager.entities.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{

}
