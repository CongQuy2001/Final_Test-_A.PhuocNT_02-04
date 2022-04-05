package fis.java.com.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.com.Entity.CaseStatus;
import fis.java.com.Entity.CriminalCase;
import fis.java.com.Repository.CriminalCaseRepository;

@Service
@Transactional

public class CriminalCaseService implements ICriminalCaseService {
	@Autowired
	private CriminalCaseRepository CaseRepository;

	@Override
	public String create(CriminalCase criminalcase) {
		String mesage = "Thất Bại";
		if (CaseRepository.existsByNumber(criminalcase.getNumber())) {
			return mesage;
		} else {
			CaseRepository.save(criminalcase);
			return "Thành Công";
		}

	}

	@Override
	public String update(CriminalCase criminalcase) {
		CriminalCase criminalcase1 = new CriminalCase();
		if (CaseRepository.findById(criminalcase.getId()).equals(null)) {
			return "ID không tồn tại";
		} else {
			criminalcase1.setNumber(criminalcase1.getNumber());
			criminalcase1.setDetailDescription(criminalcase1.getDetailDescription());
			criminalcase1.setNotes(criminalcase1.getNotes());
			criminalcase1.setShortDescription(criminalcase1.getShortDescription());
			criminalcase1.setStatus(criminalcase1.getStatus());
			criminalcase1.setType(criminalcase1.getType());
			CaseRepository.save(criminalcase1);

			return "Update Thành công";
		}

	}

	@Override
	public List<CriminalCase> getAll() {

		return CaseRepository.findAll();
	}

	@Override
	public CriminalCase getByID(Long id) {

		return CaseRepository.findById(id).get();
	}

	@Override
	public CriminalCase save(CriminalCase criminalcase) {

		return null;
	}

	@Override
	public void deleteById(Long id) {

		CaseRepository.deleteById(id);
	}

	@Override
	public List<CriminalCase> findByStatus(CaseStatus status) {
		
		return CaseRepository.findByStatus(status);
	}

}
