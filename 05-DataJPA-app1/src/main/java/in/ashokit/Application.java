package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Player;
import in.ashokit.repository.PlayerRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		PlayerRepository playerRepository = context.getBean(PlayerRepository.class);
		
		System.out.println(playerRepository.getClass().getName());
		
		Player p1=new Player();
		p1.setPlayerId(102);
		p1.setPlayerName("Aman");
		p1.setPlayerAge(21);
		p1.setLocation("Ranchi");
		
		playerRepository.delete(p1);
		System.out.println("Record inserted");
	}

}
