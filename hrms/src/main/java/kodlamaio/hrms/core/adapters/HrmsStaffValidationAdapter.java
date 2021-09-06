package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class HrmsStaffValidationAdapter {
	
	public boolean validate(Employer employer) {
		return true;
	}

}
