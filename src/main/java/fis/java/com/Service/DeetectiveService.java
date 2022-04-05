package fis.java.com.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.com.Entity.Detective;
import fis.java.com.Repository.DetectiveRepository;

@Service
@Transactional
public class DeetectiveService implements IDeetectiveService {

	@Autowired
	private DetectiveRepository detectiverepository;

	@Override
	public String create(Detective detceitive) {
		String mesage = "Thất Bại";
		if (detectiverepository.existsByBadgeNumber(detceitive.getBadgeNumber())) {
			return mesage;
		} else {
			detectiverepository.save(detceitive);
			return "Thành Công";
		}

	}

	@Override
	public String update(Detective detceitive) {
		Detective detective1 = new Detective();
		if (detectiverepository.findById(detceitive.getDetectiveId()).equals(null)) {
			return "ID không tồn tại";
		} else {
			detective1.setPerson(detective1.getPerson());
			detective1.setRanks(detective1.getRanks());
			detective1.setAmed(detective1.getAmed());
			detective1.setStatus(detective1.getStatus());
			detectiverepository.save(detective1);

			return "Update Thành công";
		}

	}

	@Override
	public List<Detective> getAll() {

		return detectiverepository.findAll();
	}

	@Override
	public Detective getByID(Long id) {

		return detectiverepository.findById(id).get();
	}

	@Override
	public Detective save(Detective detceitive) {

		return null;
	}

	@Override
	public void deleteById(Long id) {

		detectiverepository.deleteById(id);

	}

}
