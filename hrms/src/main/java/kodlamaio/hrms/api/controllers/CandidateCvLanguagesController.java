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

import kodlamaio.hrms.business.abstracts.CandidateCvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;

@RestController
@RequestMapping("/api/candidatecvlanguages")
@CrossOrigin
public class CandidateCvLanguagesController {

	private CandidateCvLanguageService candidateCvLanguageService;

	@Autowired
	public CandidateCvLanguagesController(CandidateCvLanguageService candidateCvLanguageService) {
		this.candidateCvLanguageService = candidateCvLanguageService;
	}

	@PostMapping(value = "/create")
	public Result create(@RequestBody CandidateCvLanguage candidateCvLanguage) {
		return this.candidateCvLanguageService.create(candidateCvLanguage);
	}

	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvLanguage>> getAll() {
		return this.candidateCvLanguageService.getAll();
	}

	@GetMapping(value = "getbycandidatecvid")
	public DataResult<List<CandidateCvLanguage>> getByCandidateCvId(@RequestParam long candidateCvId) {
		return this.candidateCvLanguageService.getByCandidateCvId(candidateCvId);
	}

}
