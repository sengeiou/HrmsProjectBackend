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

import kodlamaio.hrms.business.abstracts.CandidateCvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;

@RestController
@RequestMapping("/api/candidatecvexperiences")
@CrossOrigin
public class CandidateCvExperiencesController {
	
private CandidateCvExperienceService candidateCvExperienceService;
	
	@Autowired
	public CandidateCvExperiencesController(CandidateCvExperienceService candidateCvExperienceService) {
		this.candidateCvExperienceService = candidateCvExperienceService;
	}
	
	@PostMapping(value = "/create")
	public Result create(@RequestBody CandidateCvExperience candidateCvExperience) {
		return this.candidateCvExperienceService.create(candidateCvExperience);
	}

	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvExperience>> getAll() {
		return this.candidateCvExperienceService.getAll();
	}

	@GetMapping(value = "getbycandidatecvid")
	public DataResult<List<CandidateCvExperience>> getByCandidateCvId(@RequestParam long candidateCvId) {
		return this.candidateCvExperienceService.getByCandidateCvId(candidateCvId);
	}
	
	@GetMapping(value = "getbycandidatecvidorderbyquitdatedesc")
	public DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByQuitDateDesc(@RequestParam long candidateCvId) {
		return this.candidateCvExperienceService.getByCandidateCvIdOrderByQuitDateDesc(candidateCvId);
	}

}
