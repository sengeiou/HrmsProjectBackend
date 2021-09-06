package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;

public interface CandidateCvService {
	Result create(CandidateCv candidateCv);
	DataResult<List<CandidateCv>> getAll();
	DataResult<CandidateCv> getById(long id);
}
