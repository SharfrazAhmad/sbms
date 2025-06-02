package in.ashokit.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class Client {

	public void invokeSave() {
		WebClient webClient = WebClient.create();
		String url="https://jsonplaceholder.typicode.com/posts";
		
		String response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(response);
	}
}
