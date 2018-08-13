package br.minder.redmine.base;

import java.util.List;
import java.util.Optional;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@MappedSuperclass
public class DefaultController<ENTITY extends DefaultEntity, SERVICE extends BaseService<ENTITY>> {
	
	@Autowired
	private SERVICE service;

	@GetMapping
	public ResponseEntity<List<ENTITY>> getAll() {
		List<ENTITY> list = service.getAll();
		if(list != null && !list.isEmpty()) {
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.notFound().build(); 
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<ENTITY> getById(@PathVariable GeneralId id) {
		Optional<ENTITY> entity = service.find(id);
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		}
		return ResponseEntity.notFound().build();
	}	
	
	@PostMapping
	public ResponseEntity<String> post(@RequestBody ENTITY entity) {
		Optional<String> id = service.create(entity);
		if (id.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(id.get());			
		}
		return ResponseEntity.badRequest().build();	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ENTITY> put(@RequestBody ENTITY entity, @PathVariable GeneralId id) {
		Optional<ENTITY> changedEntity = service.change(id, entity);
		if (changedEntity.isPresent()) {
			return ResponseEntity.ok(changedEntity.get());			
		}
		return ResponseEntity.badRequest().build();	
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable GeneralId id) {
		if (service.remove(id)) {
			return ResponseEntity.ok().build();
		}	
		return ResponseEntity.notFound().build();
	}

}