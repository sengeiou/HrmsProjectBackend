package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Long>{

	Employer findById(long id);
	Employer findByUserId(long userId);
	Employer findByCompanyName(String companyName);
	Employer findByWebSite(String webSite);
	Employer findByPhoneNumber(String phoneNumber);
	
}
