package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvWebSite;

public interface CandidateCvWebSiteService {
	
	Result create(CandidateCvWebSite candidateCvWebSite);
	
	DataResult<List<CandidateCvWebSite>> getAll();
	
	DataResult<List<CandidateCvWebSite>> getByCandidateCvId(long candidateCvId);

}
