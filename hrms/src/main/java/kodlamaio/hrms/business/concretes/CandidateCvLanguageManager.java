package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;

@Service
public class CandidateCvLanguageManager implements CandidateCvLanguageService{
	
	private CandidateCvLanguageDao candidateCvLanguageDao;
	
	@Autowired
	public CandidateCvLanguageManager(CandidateCvLanguageDao candidateCvLanguageDao) {
		this.candidateCvLanguageDao = candidateCvLanguageDao;
	}

	@Override
	public Result create(CandidateCvLanguage candidateCvLanguage) {
		this.candidateCvLanguageDao.save(candidateCvLanguage);
		return new SuccessResult("Candidate cv language created!");
	}

	@Override
	public DataResult<List<CandidateCvLanguage>> getAll() {
		return new SuccessDataResult<List<CandidateCvLanguage>>(this.candidateCvLanguageDao.findAll(), "Candidate cv languages listed!");
	}

	@Override
	public DataResult<List<CandidateCvLanguage>> getByCandidateCvId(long candidateCvId) {
		return new SuccessDataResult<List<CandidateCvLanguage>>(this.candidateCvLanguageDao.findByCandidateCvId(candidateCvId), "Candidate cv languages listed by candidateCvId!");
	}

}
