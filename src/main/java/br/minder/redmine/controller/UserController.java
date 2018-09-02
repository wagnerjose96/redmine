package br.minder.redmine.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.minder.redmine.base.DefaultController;
import br.minder.redmine.persistence.User;
import br.minder.redmine.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserController extends DefaultController<User, UserService> {

}
