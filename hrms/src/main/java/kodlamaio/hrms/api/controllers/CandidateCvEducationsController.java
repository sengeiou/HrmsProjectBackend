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

import kodlamaio.hrms.business.abstracts.CandidateCvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;

@RestController
@RequestMapping("/api/candidatecveducations")
@CrossOrigin
public class CandidateCvEducationsController {
	
	private CandidateCvEducationService candidateCvEducationService;
	
	@Autowired
	public CandidateCvEducationsController(CandidateCvEducationService candidateCvEducationService) {
		this.candidateCvEducationService = candidateCvEducationService;
	}
	
	@PostMapping(value = "/create")
	public Result create(@RequestBody CandidateCvEducation candidateCvEducation) {
		return this.candidateCvEducationService.create(candidateCvEducation);
	}

	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvEducation>> getAll() {
		return this.candidateCvEducationService.getAll();
	}

	@GetMapping(value = "getbycandidatecvid")
	public DataResult<List<CandidateCvEducation>> getByCandidateCvId(@RequestParam long candidateCvId) {
		return this.candidateCvEducationService.getByCandidateCvId(candidateCvId);
	}
	
	@GetMapping(value = "getbycandidatecvidorderbydateofgraduationdesc")
	public DataResult<List<CandidateCvEducation>> getByCandidateCvIdOrderByDateOfGraduationDesc(@RequestParam long candidateCvId) {
		return this.candidateCvEducationService.getByCandidateCvIdOrderByDateOfGraduationDesc(candidateCvId);
	}

}
