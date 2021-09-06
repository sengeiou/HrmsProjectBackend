package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvEducationDao;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;

@Service
public class CandidateCvEducationManager implements CandidateCvEducationService{
	
	private CandidateCvEducationDao candidateCvEducationDao;
	
	@Autowired
	public CandidateCvEducationManager(CandidateCvEducationDao candidateCvEducationDao) {
		this.candidateCvEducationDao = candidateCvEducationDao;
	}

	@Override
	public Result create(CandidateCvEducation candidateCvEducation) {
		this.candidateCvEducationDao.save(candidateCvEducation);
		return new SuccessResult("Candidate cv education created!");
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getAll() {
		return new SuccessDataResult<List<CandidateCvEducation>>(this.candidateCvEducationDao.findAll(), "Candidate cv educations listed!");
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getByCandidateCvId(long candidateCvId) {
		return new SuccessDataResult<List<CandidateCvEducation>>(this.candidateCvEducationDao.findByCandidateCvId(candidateCvId), "Candidate cv educations listed by candidateCvId!");
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getByCandidateCvIdOrderByDateOfGraduationDesc(long candidateCvId) {
		return new SuccessDataResult<List<CandidateCvEducation>>(this.candidateCvEducationDao.findByCandidateCvIdOrderByDateOfGraduationDesc(candidateCvId), "Candidate cv educations listed by candidateCvId order by date of graduation descending!");
	}

}
