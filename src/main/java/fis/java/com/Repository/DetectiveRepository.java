package fis.java.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fis.java.com.Entity.CriminalCase;
import fis.java.com.Entity.Detective;

@Repository
public interface DetectiveRepository extends JpaRepository<Detective, Long> {
	boolean existsByBadgeNumber(String badgeNumber);

	CriminalCase findByBadgeNumber(String badgeNumber);
}
