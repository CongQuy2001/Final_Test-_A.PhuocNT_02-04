package fis.java.com.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import fis.java.com.Entity.Person;

public interface IPerson extends UserDetailsService  {
	Person getPersonByID(Long id);

	void createPerson(Person person);

	boolean isPersonExistsByUsername(String username);

	Person getPersonByUsername(String username);

}
