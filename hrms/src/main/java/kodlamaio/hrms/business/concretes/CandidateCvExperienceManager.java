package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;

@Service
public class CandidateCvExperienceManager implements CandidateCvExperienceService{
	
	private CandidateCvExperienceDao candidateCvExperienceDao;
	
	@Autowired
	public CandidateCvExperienceManager(CandidateCvExperienceDao candidateCvExperienceDao) {
		this.candidateCvExperienceDao = candidateCvExperienceDao;
	}

	@Override
	public Result create(CandidateCvExperience candidateCvExperience) {
		this.candidateCvExperienceDao.save(candidateCvExperience);
		return new SuccessResult("Candidate cv experience created!");
	}

	@Override
	public DataResult<List<CandidateCvExperience>> getAll() {
		return new SuccessDataResult<List<CandidateCvExperience>>(this.candidateCvExperienceDao.findAll(), "Candidate cv experiences listed!");
	}

	@Override
	public DataResult<List<CandidateCvExperience>> getByCandidateCvId(long candidateCvId) {
		return new SuccessDataResult<List<CandidateCvExperience>>(this.candidateCvExperienceDao.findByCandidateCvId(candidateCvId), "Candidate cv experiences listed by candidateCvId!");
	}

	@Override
	public DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByQuitDateDesc(long candidateCvId) {
		return new SuccessDataResult<List<CandidateCvExperience>>(this.candidateCvExperienceDao.findByCandidateCvIdOrderByQuitDateDesc(candidateCvId), "Candidate cv experiences listed by candidateCvId order by quit date descending!");
	}

}
