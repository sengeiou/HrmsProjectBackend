package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCvSkill;

public interface CandidateCvSkillDao extends JpaRepository<CandidateCvSkill, Long>{
	
	List<CandidateCvSkill> findByCandidateCvId(long candidateCvId);

}
