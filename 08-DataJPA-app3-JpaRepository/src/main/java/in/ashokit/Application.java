package in.ashokit;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		User user1 = new User(104, 27, "Bhutan", "Transgemder", "Babita");

		userRepository.save(user1);
		
		List<User> all = userRepository.findAll(Sort.by("userAge").descending());
		for (User user : all) {
			System.out.println(user);
		}
		
		

	}

}
