package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

public interface JobService {
	Result add(Job job);
	Result update(Job job);
	Result delete(int id);
	DataResult<List<Job>> getAll();
	DataResult<Job> getById(int id);
}
