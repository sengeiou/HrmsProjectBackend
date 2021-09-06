package kodlamaio.hrms.business.concretes;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.EmailValidationAdapter;
import kodlamaio.hrms.core.adapters.MernisValidationAdapter;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private Calendar calendar;
	private CandidateDao candidateDao;
	private MernisValidationAdapter mernisValidationAdapter;
	private EmailValidationAdapter emailValidationAdapter;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisValidationAdapter mernisValidationAdapter, EmailValidationAdapter emailValidationAdapter) {
		this.candidateDao = candidateDao;
		this.mernisValidationAdapter = mernisValidationAdapter;
		this.emailValidationAdapter = emailValidationAdapter;
		this.calendar = Calendar.getInstance();
	}
	
	@Override
	public Result register(Candidate candidate, String confirmPassword) {
		if(candidate.getUser().getPassword().equals(confirmPassword)) {
			this.calendar.setTime(candidate.getDateOfBirth());
			if (mernisValidationAdapter.validate(Long.parseLong(candidate.getNationalityId()), candidate.getFirstName(), candidate.getLastName(), calendar.get(Calendar.YEAR))) {
				if (emailValidationAdapter.validate(candidate.getUser().getEmail())) {
					this.candidateDao.save(candidate);
					return new SuccessResult("Candidate registered!");
				}
				return new ErrorResult("Email validation failed!");
			}
			return new ErrorResult("Not a valid person!");
		}
		return new ErrorResult("Passwords didn't match!" + candidate.getUser().getPassword() + "-" +confirmPassword);
		
	}

	@Override
	public Result delete(long id) {
		this.candidateDao.deleteById(id);
		return new SuccessResult("Candidate deleted!");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidates listed!");
	}

	@Override
	public DataResult<Candidate> getById(long id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id), "Candidate listed by id");
	}

	@Override
	public DataResult<Candidate> getByUserId(long userId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByUserId(userId), "Candidate listed by userId");
	}

	@Override
	public DataResult<Candidate> getByNationalityId(String nationalityId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalityId(nationalityId), "Candidate listed by nationalityId");
	}

}
