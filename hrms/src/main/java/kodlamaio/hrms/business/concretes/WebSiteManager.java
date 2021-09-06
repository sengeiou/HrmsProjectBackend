package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WebSiteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WebSiteDao;
import kodlamaio.hrms.entities.concretes.WebSite;

@Service
public class WebSiteManager implements WebSiteService{
	
	private WebSiteDao webSiteDao;
	
	@Autowired
	public WebSiteManager(WebSiteDao webSiteDao) {
		this.webSiteDao = webSiteDao;
	}

	@Override
	public Result add(WebSite webSite) {
		this.webSiteDao.save(webSite);
		return new SuccessResult("Web site added!");
	}

	@Override
	public DataResult<List<WebSite>> getAll() {
		return new SuccessDataResult<List<WebSite>>(this.webSiteDao.findAll(), "Web sites listed!");
	}

	@Override
	public DataResult<WebSite> getById(int id) {
		return new SuccessDataResult<WebSite>(this.webSiteDao.findById(id), "Web site listed by id");
	}
	
}
