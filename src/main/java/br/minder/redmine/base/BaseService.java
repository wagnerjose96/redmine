package br.minder.redmine.base;

import java.util.List;
import java.util.Optional;

public interface BaseService<ENTITY> {
	
	Optional<String> create(final ENTITY entity);
	Optional<ENTITY> find(final GeneralId id);
	Optional<ENTITY> change(final GeneralId id, final ENTITY entity);
	Boolean remove(final GeneralId id);
	List<ENTITY> getAll();
	
}
