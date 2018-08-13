package br.minder.redmine.persistence;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.minder.redmine.base.DefaultEntity;

@Entity
@Table(name="users")
public class User extends DefaultEntity{

	private String name;
	private String photoUrl;
	
	public User() {
		
	}

	public User(String name, String photoUrl) {
		super();
		this.name = name;
		this.photoUrl = photoUrl;
	}

	public String getName() {
		return name;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}
	
}
