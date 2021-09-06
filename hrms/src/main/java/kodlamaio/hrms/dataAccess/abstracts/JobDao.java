package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{
	Job findById(int id);
	
	@Transactional
	@Modifying
	@Query("update Job j set j.name = :name where j.id = :id")
	void update(@Param(value ="id") int id, @Param(value="name") String name);
	
}
