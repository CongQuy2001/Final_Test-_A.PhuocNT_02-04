package fis.java.com.Service;

import java.util.List;

import fis.java.com.Entity.CaseStatus;
import fis.java.com.Entity.CriminalCase;

public interface ICriminalCaseService {
	String create(CriminalCase criminalcase );

	String update(CriminalCase criminalcase );

	CriminalCase getByID(Long id);

	CriminalCase save(CriminalCase criminalcase );

	void deleteById(Long id);

	List<CriminalCase> getAll();
	
	List<CriminalCase> findByStatus(CaseStatus status);
}
