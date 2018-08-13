package br.minder.redmine.service;

import org.springframework.stereotype.Service;

import br.minder.redmine.base.DefaultService;
import br.minder.redmine.persistence.User;
import br.minder.redmine.repository.UserRespository;

@Service
public class UserService extends DefaultService<User, UserRespository>{

}
