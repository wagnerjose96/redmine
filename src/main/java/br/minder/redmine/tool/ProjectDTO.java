package br.minder.redmine.tool;

import java.util.Date;

import com.taskadapter.redmineapi.bean.Project;

public class ProjectDTO {
	private Integer id;
	private String identifier;
	private String name;
	private Date created;
	private String description;

	public ProjectDTO(Project project) {
		this.id = project.getId();
		this.identifier = project.getIdentifier();
		this.name = project.getName();
		this.created = project.getCreatedOn();
		this.description = project.getDescription();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
