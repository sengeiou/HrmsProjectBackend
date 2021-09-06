package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result create(JobAdvertisement jobAdvertisement);
	Result deactivate(long id);
	Result activate(long id);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<JobAdvertisement> getById(long id);
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByCreationDate();
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline();
	DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActiveTrue(long employerId);
}
