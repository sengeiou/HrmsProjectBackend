package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	Result register(Candidate candidate, String confirmPassword);
	Result delete(long id);
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(long id);
	DataResult<Candidate> getByUserId(long userId);
	DataResult<Candidate> getByNationalityId(String nationalityId);
}
