package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;

public interface CandidateCvLanguageService {
	
	Result create(CandidateCvLanguage candidateCvLanguage);
	
	DataResult<List<CandidateCvLanguage>> getAll();
	
	DataResult<List<CandidateCvLanguage>> getByCandidateCvId(long candidateCvId);

}
