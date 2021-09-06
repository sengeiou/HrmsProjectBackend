package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getById(long id) {
		return new SuccessDataResult<User>(this.userDao.getById(id), "User listed by id!") ;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "User Listed By Email");
	}
	
	@Override
	public Result register(User user) {
		this.userDao.save(user);
		return new SuccessResult("User registered!");
	}

	@Override
	public Result delete(long id) {
		this.userDao.deleteById(id);
		return new SuccessResult("User deleted!");
	}
	
}
