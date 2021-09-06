package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Long>{
	JobAdvertisement findById(long id);
	List<JobAdvertisement> findByIsActiveTrue();
	List<JobAdvertisement> findByIsActiveTrueOrderByCreationDate();
	List<JobAdvertisement> findByIsActiveTrueOrderByApplicationDeadline();
	List<JobAdvertisement> findByEmployerIdAndIsActiveTrue(long employerId);
	
	@Transactional
	@Modifying
	@Query("update JobAdvertisement ja set ja.isActive = false where ja.id = :id")
	void deactivate(@Param(value ="id") long id);
	
	@Transactional
	@Modifying
	@Query("update JobAdvertisement ja set ja.isActive = true where ja.id = :id")
	void activate(@Param(value ="id") long id);
}
