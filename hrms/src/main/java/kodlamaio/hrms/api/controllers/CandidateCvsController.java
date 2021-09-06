package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;

@RestController
@RequestMapping("/api/candidatecvs")
@CrossOrigin
public class CandidateCvsController {
	
	private CandidateCvService candidateCvService;
	
	@Autowired
	public CandidateCvsController(CandidateCvService candidateCvService) {
		this.candidateCvService = candidateCvService;
	}
	
	@PostMapping(value = "/create")
	public Result create(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.create(candidateCv);
	}
	
	@GetMapping(value = "getall")
	public DataResult<List<CandidateCv>> getAll(){
		return this.candidateCvService.getAll();
	}
	
	@GetMapping(value = "getbyid")
	public DataResult<CandidateCv> getById(long id){
		return this.candidateCvService.getById(id);
	}
	
}
