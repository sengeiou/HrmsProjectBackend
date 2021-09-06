package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvWebSiteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvWebSiteDao;
import kodlamaio.hrms.entities.concretes.CandidateCvWebSite;

@Service
public class CandidateCvWebSiteManager implements CandidateCvWebSiteService{
	
	private CandidateCvWebSiteDao candidateCvWebSiteDao;
	
	@Autowired
	public CandidateCvWebSiteManager(CandidateCvWebSiteDao candidateCvWebSiteDao) {
		this.candidateCvWebSiteDao = candidateCvWebSiteDao;
	}

	@Override
	public Result create(CandidateCvWebSite candidateCvWebSite) {
		this.candidateCvWebSiteDao.save(candidateCvWebSite);
		return new SuccessResult("Candidate cv web site created!");
	}

	@Override
	public DataResult<List<CandidateCvWebSite>> getAll() {
		return new SuccessDataResult<List<CandidateCvWebSite>>(this.candidateCvWebSiteDao.findAll(), "Candidate cv web sites listed!");
	}

	@Override
	public DataResult<List<CandidateCvWebSite>> getByCandidateCvId(long candidateCvId) {
		return new SuccessDataResult<List<CandidateCvWebSite>>(this.candidateCvWebSiteDao.findByCandidateCvId(candidateCvId), "Candidate cv web sites listed by candidateCvId!");
	}

}
