package in.ashokit;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserRepository bean = context.getBean(UserRepository.class);

		System.out.println(bean.getClass().getName());

		User user1 = new User(101, "Apple", "male", 24, "india");
		User user2 = new User(102, "bpple", "male", 25, "china");
		User user3 = new User(103, "cpple", "flemale", 26, "indonesia");

		bean.saveAll(Arrays.asList(user1, user2, user3));

//		--------------------------------------
		Optional<User> byId = bean.findById(104);
		if (byId.isPresent()) {
			System.out.println("mil gya");

		} else {
			System.err.println("nhi mila");
		}
//		----------------------------------------
		Iterable<User> allById = bean.findAllById(Arrays.asList(101, 102, 103, 104));
		allById.forEach(User -> {
			System.out.println(User);
		});
//		-----------------------------------------

		long count = bean.count();
		System.out.println(count);

//		-------------------------------------------
		List<User> byCountry = bean.findByCountry("India");
		for (User user : byCountry) {
			System.out.println(user);
		}

		List<User> byAge = bean.findByAge(25);
		for (User user : byAge) {
			System.out.println(user);
		}

		List<User> byAgeGreaterThanEqual = bean.findByAgeGreaterThanEqual(25);
		for (User user : byAgeGreaterThanEqual) {
			System.out.println(user);

		}

		List<User> byCountryIn = bean.findByCountryIn(Arrays.asList("India", "China"));
		for (User user : byCountryIn) {
			System.out.println(user);

		}

		List<User> byCountryAndAge = bean.findByCountryAndAge("India", 24);
		for (User user : byCountryAndAge) {
			System.out.println(user);
		}

	}

}
