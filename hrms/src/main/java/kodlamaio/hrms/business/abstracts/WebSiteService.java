package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WebSite;

public interface WebSiteService {

	Result add(WebSite webSite);
	
	DataResult<List<WebSite>> getAll();
	
	DataResult<WebSite> getById(int id);
}
