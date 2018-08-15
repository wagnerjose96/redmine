package br.minder.redmine.tool;

import java.util.Collection;

import com.taskadapter.redmineapi.bean.Membership;
import com.taskadapter.redmineapi.bean.Role;

public class MemberDTO {
	private int id;
	private String name;
	private Collection<Role> roles;

	public MemberDTO() {
	}

	public MemberDTO(Membership member) {
		this.id = member.getUserId();
		this.name = member.getUserName();
		this.roles = member.getRoles();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

}
