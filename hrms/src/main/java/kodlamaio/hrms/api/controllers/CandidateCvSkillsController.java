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

import kodlamaio.hrms.business.abstracts.CandidateCvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvSkill;

@RestController
@RequestMapping("/api/candidatecvskills")
@CrossOrigin
public class CandidateCvSkillsController {
	
	private CandidateCvSkillService candidateCvSkillService;

	@Autowired
	public CandidateCvSkillsController(CandidateCvSkillService candidateCvSkillService) {
		this.candidateCvSkillService = candidateCvSkillService;
	}

	@PostMapping(value = "/create")
	public Result create(@RequestBody CandidateCvSkill candidateCvSkill) {
		return this.candidateCvSkillService.create(candidateCvSkill);
	}

	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvSkill>> getAll() {
		return this.candidateCvSkillService.getAll();
	}

	@GetMapping(value = "getbycandidatecvid")
	public DataResult<List<CandidateCvSkill>> getByCandidateCvId(@RequestParam long candidateCvId) {
		return this.candidateCvSkillService.getByCandidateCvId(candidateCvId);
	}

}
