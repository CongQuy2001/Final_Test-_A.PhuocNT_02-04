package fis.java.com.Service;

import java.util.List;

import fis.java.com.Entity.Detective;

public interface IDeetectiveService {

	String create(Detective detceitive);

	String update(Detective detceitive);

	List<Detective> getAll();

	Detective getByID(Long id);

	Detective save(Detective detceitive);

	void deleteById(Long id);
}
