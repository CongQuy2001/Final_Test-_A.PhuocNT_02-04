package fis.java.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fis.java.com.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	boolean existsByUsername(String username);

	Person findByUsername(String username);
}
