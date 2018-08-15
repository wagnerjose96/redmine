package br.minder.redmine;

import java.io.UnsupportedEncodingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedmineApplication {

	public static void main(String[] args) throws UnsupportedEncodingException {
		SpringApplication.run(RedmineApplication.class, args);
	}
	
	
}
