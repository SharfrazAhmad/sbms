package in.ashokit.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.Laptop;
import in.ashokit.entity.User;
import in.ashokit.repository.LaptopRepo;
import in.ashokit.repository.UserRepo;

@Component
public class Runner implements CommandLineRunner{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private LaptopRepo laptopRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setRollNumber(1);
		user.setUserName("Amannn");
		user.setUserPassword("1234");
		
		
		
		
		Laptop laptop = new Laptop();
		laptop.setBatchNumber("1hf");
		laptop.setBrand("Asus");
		laptop.setSlNo(1);
		
		
		laptop.setUser(user);
		user.setLaptop(laptop);
	
		userRepo.save(user);
		
		
		
		
		
		
	}

}
