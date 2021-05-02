package com.tasksmanager.tasksmanager.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String status;
	private String creation;
	private String finished;
	
	@ManyToOne
	@JoinColumn(name = "team_member_id")
	private TeamMember teamMember;
	
	public Task() {
	}

	public Task(Long id, TeamMember teamMember, String description, String creation) {
		super();
		this.id = id;
		this.description = description;
		this.teamMember = teamMember;
		this.creation = creation;
		this.status = "Backlog";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	public String getFinished() {
		return finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
	}
	
	public TeamMember getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}