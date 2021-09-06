package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Long>{
	Candidate findById(long id);
	Candidate findByUserId(long userId);
	Candidate findByNationalityId(String nationalityId);
	
}
