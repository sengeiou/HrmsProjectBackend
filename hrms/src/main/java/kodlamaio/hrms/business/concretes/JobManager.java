package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{
	
	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public Result add(Job job) {
		this.jobDao.save(job);
		return new SuccessResult("Job added!");
	}
	
	@Override
	public Result update(Job job) {
		this.jobDao.update(job.getId(), job.getName());
		return new SuccessResult("Job updated!");
	}
	
	@Override
	public Result delete(int id) {
		this.jobDao.deleteById(id);
		return new SuccessResult("Job deleted!");
	}
	
	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Jobs listed!");
	}

	@Override
	public DataResult<Job> getById(int id) {
		return new SuccessDataResult<Job>(this.jobDao.findById(id), "Job listed by id");
	}
}
