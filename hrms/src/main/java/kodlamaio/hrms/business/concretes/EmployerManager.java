package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.adapters.EmailValidationAdapter;
import kodlamaio.hrms.core.adapters.HrmsStaffValidationAdapter;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailValidationAdapter emailValidationAdapter;
	private HrmsStaffValidationAdapter hrmsStaffValidationAdapter;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailValidationAdapter emailValidationAdapter,
			HrmsStaffValidationAdapter hrmsStaffValidationAdapter) {
		this.employerDao = employerDao;
		this.emailValidationAdapter = emailValidationAdapter;
		this.hrmsStaffValidationAdapter = hrmsStaffValidationAdapter;
	}

	@Override
	public Result register(Employer employer, String confirmPassword) {
		if (validateWebSiteAndEmailDomainMatch(employer)) {
			if (this.emailValidationAdapter.validate(employer.getUser().getEmail())) {
				if (this.hrmsStaffValidationAdapter.validate(employer)) {
					this.employerDao.save(employer);
					return new SuccessResult("Employer registered!");
				}
				return new ErrorResult("Hrms staff didn't approve!");
			}
			return new ErrorResult("Email validation failed!");
		}
		return new ErrorResult("Email and website domain should be match!");
		
	}

	@Override
	public Result delete(long id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("Employer deleted!");
	}
	
	@Override
	public DataResult<List<Employer>> getAll(){
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers listed!");
	}

	@Override
	public DataResult<Employer> getById(long id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id), "Employer listed by id!");
	}

	@Override
	public DataResult<Employer> getByUserId(long userId) {
		return new SuccessDataResult<Employer>(this.employerDao.findByUserId(userId), "Employer listed by userId!");
	}

	@Override
	public DataResult<Employer> getByCompanyName(String companyName) {
		return new SuccessDataResult<Employer>(this.employerDao.findByCompanyName(companyName), "Employer listed by companyName!");
	}

	@Override
	public DataResult<Employer> getByWebSite(String webSite) {
		return new SuccessDataResult<Employer>(this.employerDao.findByWebSite(webSite), "Employer listed by webSite!");
	}

	@Override
	public DataResult<Employer> getByPhoneNumber(String phoneNumber) {
		return new SuccessDataResult<Employer>(this.employerDao.findByPhoneNumber(phoneNumber), "Employer listed by phoneNumber!");
	}
	
	public boolean validateWebSiteAndEmailDomainMatch(Employer employer) {
		return true;
	}

}
