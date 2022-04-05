package fis.java.com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fis.java.com.Entity.CriminalCase;
import fis.java.com.Entity.Evidence;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
	boolean existsByNumber(String number);

	CriminalCase findByNumber(String number);

	List<Evidence> findByCriminalCase(CriminalCase criminalCase);
}
