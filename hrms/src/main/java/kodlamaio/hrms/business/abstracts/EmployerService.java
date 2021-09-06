package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {

	Result register(Employer employer, String confirmPassword);
	Result delete(long id);
	DataResult<List<Employer>> getAll();
	DataResult<Employer> getById(long id);
	DataResult<Employer> getByUserId(long userId);
	DataResult<Employer> getByCompanyName(String companyName);
	DataResult<Employer> getByWebSite(String webSite);
	DataResult<Employer> getByPhoneNumber(String phoneNumber);
}
