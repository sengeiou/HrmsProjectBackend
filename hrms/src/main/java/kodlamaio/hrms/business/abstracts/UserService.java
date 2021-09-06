package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;

public interface UserService{
	DataResult<User> getById(long id);
	DataResult<User> getByEmail(String email);
	Result register(User user);
	Result delete(long id);
}
