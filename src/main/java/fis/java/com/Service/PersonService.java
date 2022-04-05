package fis.java.com.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fis.java.com.Entity.Person;
import fis.java.com.Repository.PersonRepository;
@Service
public class PersonService implements IPerson{
@Autowired
private PersonRepository personRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Person person = personRepository.findByUsername(username);
	if(person==null) {
		throw new UsernameNotFoundException(username);
	}
		
		return new org.springframework.security.core.userdetails.User(person.getUsername(), person.getPassword(), Collections.emptyList());
		
	}

	@Override
	public Person getPersonByID(Long id) {
		return personRepository.findById(id).get();
	
	}

	@Override
	public void createPerson(Person person) {
		
		personRepository.save(person);
	}

	@Override
	public boolean isPersonExistsByUsername(String username) {
		
		return personRepository.existsByUsername(username);
	}

	@Override
	public Person getPersonByUsername(String username) {
		
		return personRepository.findByUsername(username);
	}



}
