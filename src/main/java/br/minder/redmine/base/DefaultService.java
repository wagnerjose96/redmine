package br.minder.redmine.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.MappedSuperclass;

import java.util.List;
import java.util.Optional;


@MappedSuperclass
public class DefaultService<
	ENTITY extends DefaultEntity,
	REPOSITORY extends JpaRepository<ENTITY, GeneralId>> implements BaseService<ENTITY> {

		@Autowired
		private REPOSITORY repository;
		
		public Optional<String> create(final ENTITY entity) {
		    return Optional.of(repository.save(entity).getId());	
		}

		public Optional<ENTITY> find(final GeneralId id){
			return repository.findById(id);	
		}
		
		public Optional<ENTITY> change(final GeneralId id, final ENTITY entity) {
			if(repository.existsById(id)) {
				entity.setId(id);
				return Optional.of(repository.save(entity));
			}
			return Optional.empty();
		}
		
		public Boolean remove(final GeneralId id) {
			if(repository.existsById(id)) {
				repository.deleteById(id);
				return true;
			}
		    return false;
		}

		public List<ENTITY> getAll() {
			return repository.findAll();
		}

}