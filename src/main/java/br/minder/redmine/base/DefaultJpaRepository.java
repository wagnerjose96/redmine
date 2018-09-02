package br.minder.redmine.base;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultJpaRepository <ENTITY extends DefaultEntity> extends JpaRepository<ENTITY, GeneralId> {

}