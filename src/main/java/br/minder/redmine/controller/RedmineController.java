package br.minder.redmine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskadapter.redmineapi.bean.Membership;
import com.taskadapter.redmineapi.bean.Project;
import com.taskadapter.redmineapi.bean.TimeEntryActivity;

import br.minder.redmine.base.GeneralId;
import br.minder.redmine.provider.RedmineProvider;
import br.minder.redmine.tool.ActivityDTO;
import br.minder.redmine.tool.IssueDTO;
import br.minder.redmine.tool.MemberDTO;
import br.minder.redmine.tool.ProjectDTO;
import br.minder.redmine.tool.TimeEntryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@CrossOrigin
@RestController
@RequestMapping("api")
public class RedmineController {

	@ApiOperation("Look the all issues")
	@GetMapping(value = "/issue", produces = "application/json")
	public ResponseEntity<List<IssueDTO>> getAllIssue() {
		List<IssueDTO> issues = RedmineProvider.getIssueDTO();
		return ResponseEntity.ok(issues);
	}

	@ApiOperation("Look the a user's time entry by id")
	@GetMapping(value = "/time/{id}", produces = "application/json")
	public ResponseEntity<List<TimeEntryDTO>> getIssueKey(@PathVariable GeneralId id) {
		List<TimeEntryDTO> timeEntries = RedmineProvider.getUserTimeEntryDTO(id);
		return ResponseEntity.ok(timeEntries);
	}
	
	@ApiOperation("Look the one time entry")
	@GetMapping(value = "/time", produces = "application/json")
	public ResponseEntity<List<TimeEntryDTO>> getIssueKey() {
		List<TimeEntryDTO> timeEntries = RedmineProvider.getTimeEntryDTO();
		return ResponseEntity.ok(timeEntries);
	}
	
	@ApiOperation("Look the all team members")
	@GetMapping(value = "/team", produces = "application/json")
	public ResponseEntity<List<MemberDTO>> getTeam() {
		List<MemberDTO> teamMembers = new ArrayList<MemberDTO>();
		List<Membership> members = RedmineProvider.getTeamMembersDTO();
		for (Membership membership : members) {
			teamMembers.add(new MemberDTO(membership));
		}
		return ResponseEntity.ok(teamMembers);
	}
	
	@ApiOperation("Look the project description")
	@GetMapping(value = "/project" , produces = "application/json")
	public ResponseEntity<ProjectDTO> getProjectKey() {
		Project project = RedmineProvider.searchProject();
		return ResponseEntity.ok(new ProjectDTO(project));
	}
	
	@ApiOperation("Look the all activitys description")
	@GetMapping(value = "/activity", produces = "application/json")
	public ResponseEntity<List<ActivityDTO>> getAllActivity() {
		List<TimeEntryActivity> listActivitys = RedmineProvider.searchAllActivitys();
		List<ActivityDTO> list = new ArrayList<ActivityDTO>();
		for (TimeEntryActivity activity : listActivitys) {
			list.add(new ActivityDTO(activity));
		}
		return ResponseEntity.ok(list);
	}

}
