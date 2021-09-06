package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.entities.concretes.CandidateCv;

@Service
public class CandidateCvManager implements CandidateCvService{

	private CandidateCvDao candidateCvDao;
	
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao) {
		this.candidateCvDao = candidateCvDao;
	}
	
	@Override
	public Result create(CandidateCv candidateCv) {
		this.candidateCvDao.save(candidateCv);
		return new SuccessResult("Candidate cv created!");
	}

	@Override
	public DataResult<List<CandidateCv>> getAll() {
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.findAll(), "Candidate cvs listed!");
	}

	@Override
	public DataResult<CandidateCv> getById(long id) {
		return new SuccessDataResult<CandidateCv>(this.candidateCvDao.findById(id), "Candidate cv listed by id!");
	}

}
