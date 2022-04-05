package fis.java.com.Service;

import java.util.List;

import fis.java.com.Entity.Evidence;

public interface IEvidenceService {
	String create(Evidence evidence);

	String update(Evidence evidence);

	List<Evidence> getAll();

	Evidence getByID(Long id);

	Evidence save(Evidence evidence);

	void deleteById(Long id);


}
