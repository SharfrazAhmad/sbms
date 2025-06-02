package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Employee;
import jakarta.transaction.Transactional;
@Transactional(rollbackOn = Exception.class)
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	
}
