package fis.java.com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fis.java.com.Entity.CaseStatus;
import fis.java.com.Entity.CaseType;
import fis.java.com.Entity.CriminalCase;

@Repository
public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Long> {
	boolean existsByNumber(String number);

	CriminalCase findByNumber(String number);

	List<CriminalCase> findByStatus(CaseStatus status);

	List<CriminalCase> findByType(CaseType type);
}
