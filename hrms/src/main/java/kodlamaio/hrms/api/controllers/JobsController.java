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

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin
public class JobsController {

	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping(value = "/add")
	public Result add(@RequestBody Job job) {
		return this.jobService.add(job);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody Job job) {
		return this.jobService.update(job);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestParam int id) {
		return this.jobService.delete(id);
	}

	@GetMapping(value = "/getall")
	public DataResult<List<Job>> getAll() {
		return this.jobService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<Job> getById(@RequestParam int id) {
		return this.jobService.getById(id);
	}

}
