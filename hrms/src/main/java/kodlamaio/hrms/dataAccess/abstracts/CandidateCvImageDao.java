package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCvImage;

public interface CandidateCvImageDao extends JpaRepository<CandidateCvImage, Long>{
	
	List<CandidateCvImage> findByCandidateCvId(long candidateCvId);
	CandidateCvImage findByCandidateCv_Candidate_Id(long candidateId);
}
