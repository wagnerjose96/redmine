package br.minder.redmine.tool;

import com.taskadapter.redmineapi.bean.TimeEntryActivity;

public class ActivityDTO {
	private Integer id;
	private String name;

	public ActivityDTO(TimeEntryActivity activity) {
		this.id = activity.getId();
		this.name = activity.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
