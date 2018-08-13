package br.minder.redmine.base;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@SuppressWarnings("serial")
@MappedSuperclass
@Embeddable
public class GeneralId implements Serializable {
	
	private String id;
	
	public GeneralId() {
		this.id = UUID.randomUUID().toString();
	}
	
	public GeneralId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.id;
	}

}