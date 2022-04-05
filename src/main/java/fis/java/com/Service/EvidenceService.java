package fis.java.com.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.com.Entity.Detective;
import fis.java.com.Entity.Evidence;
import fis.java.com.Repository.EvidenceRepository;

@Service
@Transactional
public class EvidenceService implements IEvidenceService {
	@Autowired
	private EvidenceRepository evidencerepository;

	@Override
	public String create(Evidence evidence) {
		String mesage = "Thất Bại";
		if (evidencerepository.existsByNumber(evidence.getNumber())) {
			return mesage;
		} else {
			evidencerepository.save(evidence);
			return "Thành Công";

		}

	}

	@Override
	public String update(Evidence evidence) {
		Evidence evidence1 = new Evidence();
		if (evidencerepository.findById(evidence.getEvidenceId()).equals(null)) {
			return "ID không tồn tại";
		} else {
			evidence1.setNumber(evidence1.getNumber());
			evidence1.setItemName(evidence1.getItemName());
			evidence1.setNotes(evidence1.getItemName());
			evidence1.setArchived(evidence1.getArchived());

			evidencerepository.save(evidence1);

			return "Update Thành công";
		}

	}

	@Override
	public List<Evidence> getAll() {

		return evidencerepository.findAll();
	}

	@Override
	public Evidence getByID(Long id) {

		return evidencerepository.findById(id).get();
	}

	@Override
	public Evidence save(Evidence evidence) {

		return null;
	}

	@Override
	public void deleteById(Long id) {

		evidencerepository.deleteById(id);
	}

}
