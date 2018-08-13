package br.minder.redmine.base;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class DefaultEntity {
	
	@EmbeddedId
	private GeneralId id;
	
	public DefaultEntity() {
		this.id = new GeneralId();
	}
	
	public DefaultEntity(GeneralId id){
		this.id = id;
	}
	
	public String getId() {
		return this.id.getId();
	}

	public void setId(GeneralId id) {
		this.id = id;
	}
}