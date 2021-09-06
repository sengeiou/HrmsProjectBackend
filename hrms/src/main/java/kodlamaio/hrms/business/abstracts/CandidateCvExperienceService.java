package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;

public interface CandidateCvExperienceService {
	
	Result create(CandidateCvExperience candidateCvExperience);
	
	DataResult<List<CandidateCvExperience>> getAll();
	
	DataResult<List<CandidateCvExperience>> getByCandidateCvId(long candidateCvId);
	
	DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByQuitDateDesc(long candidateCvId);

}
