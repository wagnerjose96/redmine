package br.minder.redmine.tool;

public class TimeEntryDTO {
	private String sprint;
	private String date;
	private String user;
	private String activity;
	private Float hours;

	public TimeEntryDTO() {

	}

	public TimeEntryDTO(String sprint, String date, String user, String activity, Float hours) {
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

	@Override
	public String toString() {
		return "TimeEntries [sprint=" + sprint + ", date=" + date + ", user=" + user + ", activity=" + activity
				+ ", hours=" + hours + "]";
	}

}
