package fis.java.com.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import fis.java.com.Entity.Person;
public interface PersonDao extends JpaRepository<Person, String> {
	@Query("SELECT DISTINCT ar.account FROM Detective ar WHERE ar.role.id IN('DIRE','STAF')")
	List<Person> getAdministrators();
}
