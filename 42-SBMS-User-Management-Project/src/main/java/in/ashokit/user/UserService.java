package in.ashokit.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> listAll() {
		 List<User> all = repo.findAll();
		 return all;
	}
	
	
	
	
}
