package in.ashokit.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.binding.Object;

@Component
public class PostClient {
	public void invokeObject() {
		Object object = new Object(11, 1, "temporibus sit alias", "doloremque ex facilis sit sint culpa\\nsoluta assumenda eligendi non ut eius\\nsequi");
		
		String url="https://jsonplaceholder.typicode.com/posts/";
		
		WebClient webClient = WebClient.create();
		String block = webClient.post().uri(url).bodyValue(object).retrieve().bodyToMono(String.class).block();
		System.out.println(block);
		
	}
}
