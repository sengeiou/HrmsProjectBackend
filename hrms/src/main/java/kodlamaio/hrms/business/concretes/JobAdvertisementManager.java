package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public Result create(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement created!");
	}
	
	@Override
	public Result deactivate(long id) {
		this.jobAdvertisementDao.deactivate(id);
		return new SuccessResult("Job advertisement deactivated!");
	}
	
	@Override
	public Result activate(long id) {
		this.jobAdvertisementDao.activate(id);
		return new SuccessResult("Job advertisement activated!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Job advertisements listed!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue(), "Active job advertisements listed!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByCreationDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByCreationDate(), "Active job advertisements listed order by creation date!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByApplicationDeadline(), "Active job advertisements listed order by application deadline!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActiveTrue(long employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployerIdAndIsActiveTrue(employerId), "Active job advertisements listed by employerId order by application deadline!");
	}

	@Override
	public DataResult<JobAdvertisement> getById(long id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id), "Job advertisement listed by id");
	}

}
