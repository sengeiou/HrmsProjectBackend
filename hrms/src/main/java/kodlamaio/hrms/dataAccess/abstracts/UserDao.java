package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Long>{
	User findById(long id);
	User findByEmail(String email);
	
}
