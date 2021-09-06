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

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
	
	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@PostMapping(value = "/register")
	public Result register(@RequestBody Candidate candidate, @RequestParam String confirmPassword) {
		 return this.candidateService.register(candidate, confirmPassword);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(long id) {
		return this.candidateService.delete(id);
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}

	@GetMapping(value = "/getbyid")
	public DataResult<Candidate> getById(@RequestParam long id) {
		return this.candidateService.getById(id);
	}
	
	@GetMapping(value = "/getbyuserid")
	public DataResult<Candidate> getByUserId(@RequestParam long userId) {
		return this.candidateService.getByUserId(userId);
	}

	@GetMapping(value = "/getbynationalityid")
	public DataResult<Candidate> getByNationalityId(@RequestParam String nationalityId) {
		return this.candidateService.getByNationalityId(nationalityId);
	}

}
