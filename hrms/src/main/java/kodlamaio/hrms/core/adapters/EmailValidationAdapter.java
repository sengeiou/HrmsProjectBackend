package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

@Service
public class EmailValidationAdapter {
	
	public boolean validate(String email) {
		return true;
	}

}
