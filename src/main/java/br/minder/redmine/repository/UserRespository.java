package br.minder.redmine.repository;

import org.springframework.stereotype.Repository;

import br.minder.redmine.base.DefaultJpaRepository;
import br.minder.redmine.persistence.User;

@Repository
public interface UserRespository extends DefaultJpaRepository<User> {

}
