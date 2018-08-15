package br.minder.redmine.persistence;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.minder.redmine.base.DefaultEntity;

@Entity
@Table(name = "users")
public class User extends DefaultEntity {
	private String id;
	private String name;
	private String photoUrl;

	public User() {

	}

	public User(String name, String photoUrl, String id) {
		super();
		this.name = name;
		this.photoUrl = photoUrl;
		this.id = id;

	}

	public String getName() {
		return name;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public String getId() {
		return id;
	}

}
