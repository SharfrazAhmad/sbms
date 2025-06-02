package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Employee;
import in.ashokit.repository.IEmployeeRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		IEmployeeRepository employeeRepository = context.getBean(IEmployeeRepository.class);
		Employee employee1 = new Employee(null, "apple", 25000);
		employeeRepository.save(employee1);
		
	}

}
