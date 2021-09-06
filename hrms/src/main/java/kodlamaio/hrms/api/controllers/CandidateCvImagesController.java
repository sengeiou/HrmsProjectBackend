package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateCvImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;

@RestController
@RequestMapping("/api/candidatecvimages")
@CrossOrigin
public class CandidateCvImagesController {

	private CandidateCvImageService candidateCvImageService;

	@Autowired
	public CandidateCvImagesController(CandidateCvImageService candidateCvImageService) {
		this.candidateCvImageService = candidateCvImageService;
	}

	@PostMapping(value = "/create")
	public Result create(@RequestPart("file") MultipartFile candidateCvImage, @RequestParam long id) {
		return this.candidateCvImageService.create(candidateCvImage, id);
	}

	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvImage>> getAll() {
		return this.candidateCvImageService.getAll();
	}

	@GetMapping(value = "getbycandidatecvid")
	public DataResult<List<CandidateCvImage>> getByCandidateCvId(@RequestParam long candidateCvId) {
		return this.candidateCvImageService.getByCandidateCvId(candidateCvId);
	}

	@GetMapping(value = "getbycandidateid")
	public DataResult<CandidateCvImage> getByCandidateId(@RequestParam long candidateId) {
		return this.candidateCvImageService.getByCandidateId(candidateId);
	}
}
