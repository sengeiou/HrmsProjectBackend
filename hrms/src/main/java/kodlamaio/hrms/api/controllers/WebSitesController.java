package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WebSiteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WebSite;

@RestController
@RequestMapping("/api/websites")
@CrossOrigin
public class WebSitesController {
	
	private WebSiteService webSiteService;
	
	@Autowired
	public WebSitesController(WebSiteService webSiteService) {
		this.webSiteService = webSiteService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody WebSite webSite) {
		return this.webSiteService.add(webSite);
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<WebSite>> getAll(){
		return this.webSiteService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<WebSite> getById(@RequestParam int id){
		return this.webSiteService.getById(id);
	}

}
