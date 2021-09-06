package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WebSite;

public interface WebSiteDao extends JpaRepository<WebSite, Integer>{
	WebSite findById(int id);
}
