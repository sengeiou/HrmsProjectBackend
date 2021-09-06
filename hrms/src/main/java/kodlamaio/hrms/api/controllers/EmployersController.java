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

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	@PostMapping(value="/register")
	public Result register(@RequestBody Employer employer, @RequestParam String confirmPassword) {
		return this.employerService.register(employer, confirmPassword);
	}
	
	@PostMapping(value="/delete")
	public Result delete(@RequestParam long id) {
		return this.employerService.delete(id);
	}
	
	@GetMapping(value="/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping(value="/getbyid")
	public DataResult<Employer> getById(@RequestParam long id){
		return this.employerService.getById(id);
	}
	
	@GetMapping(value="/getbyuserid")
	public DataResult<Employer> getByUserId(@RequestParam long userId){
		return this.employerService.getByUserId(userId);
	}
	
	@GetMapping(value="/getbycompanyname")
	public DataResult<Employer> getByCompanyName(@RequestParam String companyName){
		return this.employerService.getByCompanyName(companyName);
	}
	
	@GetMapping(value="/getbywebsite")
	public DataResult<Employer> getByWebSite(@RequestParam String webSite){
		return this.employerService.getByWebSite(webSite);
	}
	
	@GetMapping(value="/getbyphonenumber")
	public DataResult<Employer> getByPhoneNumber(@RequestParam String phoneNumber){
		return this.employerService.getByPhoneNumber(phoneNumber);
	}
}
