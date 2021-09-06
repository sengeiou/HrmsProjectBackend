package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvSkillDao;
import kodlamaio.hrms.entities.concretes.CandidateCvSkill;

@Service
public class CandidateCvSkillManager implements CandidateCvSkillService{
	
	private CandidateCvSkillDao candidateCvSkillDao;
	
	@Autowired
	public CandidateCvSkillManager(CandidateCvSkillDao candidateCvSkillDao) {
		this.candidateCvSkillDao = candidateCvSkillDao;
	}

	@Override
	public Result create(CandidateCvSkill candidateCvSkill) {
		this.candidateCvSkillDao.save(candidateCvSkill);
		return new SuccessResult("Candidate cv skill created!");
	}

	@Override
	public DataResult<List<CandidateCvSkill>> getAll() {
		return new SuccessDataResult<List<CandidateCvSkill>>(this.candidateCvSkillDao.findAll(), "Candidate cv skills listed!");
	}

	@Override
	public DataResult<List<CandidateCvSkill>> getByCandidateCvId(long candidateCvId) {
		return new SuccessDataResult<List<CandidateCvSkill>>(this.candidateCvSkillDao.findByCandidateCvId(candidateCvId), "Candidate cv skills listed by candidateCvId!");
	}

}
