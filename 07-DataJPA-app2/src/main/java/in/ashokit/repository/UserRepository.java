package in.ashokit.repository;

import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.User;
import java.util.List;


public interface UserRepository extends CrudRepository<User	, Integer>{
	
	public List<User> findByCountry(String country);
	public List<User> findByAge(Integer age);
	public List<User> findByAgeGreaterThanEqual(Integer age);
	public List<User> findByCountryIn(List<String> country);
	public List<User> findByCountryAndAge(String country, Integer age);

}
