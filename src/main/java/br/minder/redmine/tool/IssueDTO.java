package br.minder.redmine.tool;

public class IssueDTO {
	private String id;
	private String sprint;
	private String tracker;
	private String status;
	private String priority;
	private String subject;
	private String assignee;
	private Float estimated_time;
	private Integer pontos;
	private Float spent_time;
	private String closed;
	private String category;
	private String start_date;
	private String updated;
	private String created;
	private String parent_task;
	
	public IssueDTO() {
		
	}

	public IssueDTO(String id, String sprint, String tracker, String status, String priority, String subject,
			String assignee, Float estimated_time, Integer pontos, Float spent_time, String closed, String category,
			String start_date, String updated, String created, String parent_task) {
		this.id = id;
		this.sprint = sprint;
		this.tracker = tracker;
		this.status = status;
		this.priority = priority;
		this.subject = subject;
		this.assignee = assignee;
		this.estimated_time = estimated_time;
		this.pontos = pontos;
		this.spent_time = spent_time;
		this.closed = closed;
		this.category = category;
		this.start_date = start_date;
		this.updated = updated;
		this.created = created;
		this.parent_task = parent_task;
	}

	public String getId() {
		return id;
	}

	public String getSprint() {
		return sprint;
	}

	public String getTracker() {
		return tracker;
	}

	public String getStatus() {
		return status;
	}

	public String getPriority() {
		return priority;
	}

	public String getSubject() {
		return subject;
	}

	public String getAssignee() {
		return assignee;
	}

	public Float getEstimated_time() {
		return estimated_time;
	}

	public Integer getPontos() {
		return pontos;
	}

	public Float getSpent_time() {
		return spent_time;
	}

	public String getClosed() {
		return closed;
	}

	public String getCategory() {
		return category;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getUpdated() {
		return updated;
	}

	public String getCreated() {
		return created;
	}

	public String getParent_task() {
		return parent_task;
	}

	@Override
	public String toString() {
		return "Issues [id=" + id + ", sprint=" + sprint + ", tracker=" + tracker + ", status=" + status + ", priority="
				+ priority + ", subject=" + subject + ", assignee=" + assignee + ", estimated_time=" + estimated_time
				+ ", pontos=" + pontos + ", spent_time=" + spent_time + ", closed=" + closed + ", category=" + category
				+ ", start_date=" + start_date + ", updated=" + updated + ", created=" + created + ", parent_task="
				+ parent_task + "]";
	}
	
}
