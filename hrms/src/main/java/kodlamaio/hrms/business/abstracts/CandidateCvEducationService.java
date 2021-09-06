package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;

public interface CandidateCvEducationService {
	
	Result create(CandidateCvEducation candidateCvEducation);
	
	DataResult<List<CandidateCvEducation>> getAll();
	
	DataResult<List<CandidateCvEducation>> getByCandidateCvId(long candidateCvId);
	
	DataResult<List<CandidateCvEducation>> getByCandidateCvIdOrderByDateOfGraduationDesc(long candidateCvId);

}
