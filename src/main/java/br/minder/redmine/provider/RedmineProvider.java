package br.minder.redmine.provider;

import java.util.ArrayList;
import java.util.List;

import br.minder.redmine.base.GeneralId;
import br.minder.redmine.tool.IssueDTO;
import br.minder.redmine.tool.Properties;
import br.minder.redmine.tool.TimeEntryDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.client.RestTemplate;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Membership;
import com.taskadapter.redmineapi.bean.Project;
import com.taskadapter.redmineapi.bean.TimeEntryActivity;

public class RedmineProvider {
	private final static String KEY = "key=f8074001766559eedd4e4d661e3098d9e26f6c93";
	private final static String PROJECT = "/projects/escoladeti2018time03";
	private final static String PER_PAGE = "per_page=100";
	private final static String PAGE = "page=";
	private final static String SERVER_PORT = "http://escoladeti.unicesumar.edu.br:8082";
	private final static String TIME_ENTRIES = SERVER_PORT + PROJECT
			+ "/time_entries?utf8=✓&f[]=spent_on&op[spent_on]=*&f[]=&available_columns[]=issue&c[]=issue.cf_3&c[]=spent_on&c[]=user&op[user_id]=igual a&v[user_id]=490&c[]=activity&c[]=hours";
	private final static String ISSUES = SERVER_PORT + PROJECT
			+ "/issues?utf8=✓&set_filter=1&f[]=status_id&op[status_id]=*&f[]=&c[]=cf_3&c[]=tracker&c[]=status&c[]=priority&c[]=subject&c[]=assigned_to&c[]=estimated_hours&c[]=cf_2&c[]=spent_hours&c[]=closed_on&c[]=category&c[]=start_date&c[]=updated_on&c[]=created_on&c[]=parent";

	public static List<TimeEntryDTO> getTimeEntryDTO() {
		List<TimeEntryDTO> list = new ArrayList<TimeEntryDTO>();
		Document page = null;
		Elements trs = null;
		int pageNumber = 1;

		do {
			page = Jsoup.parse(new RestTemplate().getForObject(buildURL(pageNumber++, TIME_ENTRIES), String.class));

			trs = page.getElementsByClass("time-entry");

			for (Element tr : trs) {
				TimeEntryDTO timeEntries = new TimeEntryDTO(tr.getElementsByClass("issue_cf_3").text(),
						tr.getElementsByClass("spent_on").text(), tr.select("a,user").text(),
						tr.getElementsByClass("activity").text(), parseToFloat(tr.getElementsByClass("hours").text()));
				list.add(timeEntries);
			}
		} while (!trs.isEmpty());

		return list;
	}

	public static List<TimeEntryDTO> getUserTimeEntryDTO(GeneralId userId) {
		final String init = "/time_entries?utf8=✓&f[]=spent_on&op[spent_on]=*&f[]=user_id&op[user_id]==&v[user_id][]=";
		final String end = "&f[]=&c[]=issue.cf_3&c[]=spent_on&c[]=user&c[]=hours";
		List<TimeEntryDTO> list = new ArrayList<TimeEntryDTO>();
		Document page = null;
		Elements trs = null;
		int pageNumber = 1;

		do {
			page = Jsoup.parse(new RestTemplate().getForObject(
					buildURL(pageNumber++, SERVER_PORT + PROJECT + init + userId.getId() + end), String.class));

			trs = page.getElementsByClass("time-entry");

			for (Element tr : trs) {
				TimeEntryDTO timeEntries = new TimeEntryDTO(tr.getElementsByClass("issue_cf_3").text(),
						tr.getElementsByClass("spent_on").text(), tr.select("a,user").text(),
						tr.getElementsByClass("activity").text(), parseToFloat(tr.getElementsByClass("hours").text()));
				list.add(timeEntries);
			}
		} while (!trs.isEmpty());

		return list;
	}

	public static List<IssueDTO> getIssueDTO() {
		List<IssueDTO> list = new ArrayList<IssueDTO>();
		Document page = null;
		Elements trs = null;
		int pageNumber = 1;
		do {
			page = Jsoup.parse(new RestTemplate().getForObject(buildURL(pageNumber++, ISSUES), String.class));

			trs = page.getElementsByClass("issue");

			for (Element tr : trs) {
				IssueDTO timeEntries = new IssueDTO(tr.getElementsByClass("id").text(),
						tr.getElementsByClass("cf_3").text(), tr.getElementsByClass("tracker").text(),
						tr.getElementsByClass("status").text(), tr.getElementsByClass("priority").text(),
						tr.getElementsByClass("subject").text(), tr.getElementsByClass("assigned_to").text(),
						parseToFloat(tr.getElementsByClass("estimated_hours").text()),
						parseToInteger(tr.getElementsByClass("cf_2").text()),
						parseToFloat(tr.getElementsByClass("spent_hours").text()),
						tr.getElementsByClass("closed_on").text(), tr.getElementsByClass("category").text(),
						tr.getElementsByClass("start_date").text(), tr.getElementsByClass("updated_on").text(),
						tr.getElementsByClass("created_on").text(), tr.getElementsByClass("parent").text());

				list.add(timeEntries);
			}

		} while (!trs.isEmpty());

		return list;
	}

	public static List<TimeEntryActivity> searchAllActivitys() {
		List<TimeEntryActivity> activitys = null;
		try {
			RedmineManager mgr = RedmineManagerFactory.createWithApiKey(Properties.uriRedmine(),
					Properties.apiAccessKey());
			activitys = mgr.getTimeEntryManager().getTimeEntryActivities();
		} catch (RedmineException e) {
			e.printStackTrace();
		}
		return activitys;
	}
	
	public static List<Membership> getTeamMembersDTO() {
		List<Membership> members = new ArrayList<Membership>();
		RedmineManager mgr = RedmineManagerFactory.createWithApiKey(Properties.uriRedmine(), Properties.apiAccessKey());
		try {
			members = mgr.getMembershipManager().getMemberships(Properties.projectKey());
		} catch (RedmineException e) {
			e.printStackTrace();
		}
		return members;
	}

	public static Project searchProject() {
		Project project = null;
		RedmineManager mgr = RedmineManagerFactory.createWithApiKey(Properties.uriRedmine(), Properties.apiAccessKey());
		try {
			project = mgr.getProjectManager().getProjectByKey(Properties.projectKey());
		} catch (RedmineException e) {
			e.printStackTrace();
		}
		return project;
	}

	private static Float parseToFloat(String value) {
		return value == null || value.isEmpty() ? null : Float.parseFloat(value);
	}

	private static Integer parseToInteger(String value) {
		return value == null || value.isEmpty() ? null : Integer.parseInt(value);
	}

	private static String buildURL(int page, String urlBase) {
		return urlBase + "&" + PER_PAGE + "&" + PAGE + page + "&" + KEY;
	}

}
