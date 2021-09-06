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

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping(value = "/create")
	public Result create(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.create(jobAdvertisement);
	}
	
	@PostMapping(value = "/deactivate")
	public Result deactivate(@RequestParam long id) {
		return this.jobAdvertisementService.deactivate(id);
	}
	
	@PostMapping(value = "/activate")
	public Result activate(@RequestParam long id) {
		return this.jobAdvertisementService.activate(id);
	}

	@GetMapping(value = "/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<JobAdvertisement> getById(@RequestParam long id) {
		return this.jobAdvertisementService.getById(id);
	}

	@GetMapping(value = "/getbyisactivetrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return this.jobAdvertisementService.getByIsActiveTrue();
	}

	@GetMapping(value = "/getbyisactivetrueorderbycreationdate")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByCreationDate() {
		return this.jobAdvertisementService.getByIsActiveTrueOrderByCreationDate();
	}

	@GetMapping(value = "/getbyisactivetrueorderbyapplicationdeadline")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline() {
		return this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadline();
	}

	@GetMapping(value = "/getbyemployeridandisactivetrue")
	public DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActiveTrue(@RequestParam long employerId) {
		return this.jobAdvertisementService.getByEmployerIdAndIsActiveTrue(employerId);
	}

}
