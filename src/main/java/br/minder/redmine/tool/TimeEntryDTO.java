package br.minder.redmine.tool;

public class TimeEntryDTO {
	private String sprint;
	private String date;
	private String user;
	private String activity;
	private Float hours;
	private int idSprint;

	public TimeEntryDTO() {

	}

	public TimeEntryDTO(int idSprint, String sprint, String date, String user, String activity, Float hours) {
		this.idSprint = idSprint;
		this.sprint = sprint;
		this.date = date;
		this.user = user;
		this.activity = activity;
		this.hours = hours;
	}

	public String getSprint() {
		return sprint;
	}

	public String getDate() {
		return date;
	}

	public String getUser() {
		return user;
	}

	public String getActivity() {
		return activity;
	}

	public Float getHours() {
		return hours;
	}

	public int getIdSprint() {
		return idSprint;
	}

	@Override
	public String toString() {
		return "TimeEntries [sprint=" + sprint + ", date=" + date + ", user=" + user + ", activity=" + activity
				+ ", hours=" + hours + "]";
	}

}
