package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvSkill;

public interface CandidateCvSkillService {
	
	Result create(CandidateCvSkill candidateCvSkill);
	
	DataResult<List<CandidateCvSkill>> getAll();
	
	DataResult<List<CandidateCvSkill>> getByCandidateCvId(long candidateCvId);

}
