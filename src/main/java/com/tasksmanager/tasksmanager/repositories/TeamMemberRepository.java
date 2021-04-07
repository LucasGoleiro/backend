package com.tasksmanager.tasksmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasksmanager.tasksmanager.entities.TeamMember;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long>{
	

}
