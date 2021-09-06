package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCvEducation;

public interface CandidateCvEducationDao extends JpaRepository<CandidateCvEducation, Long>{
	
	List<CandidateCvEducation> findByCandidateCvId(long candidateCvId);
	
	List<CandidateCvEducation> findByCandidateCvIdOrderByDateOfGraduationDesc(long candidateCvId);

}
