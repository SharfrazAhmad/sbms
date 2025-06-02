package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	
	
	
}
