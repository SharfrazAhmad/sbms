package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		String apiUrl="https://api.restful-api.dev/objects";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> forEntity = template.getForEntity(apiUrl, String.class);
		String body = forEntity.getBody();
		System.out.println(body);
	}

}
