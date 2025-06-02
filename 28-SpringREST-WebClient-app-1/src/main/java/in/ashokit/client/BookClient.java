package in.ashokit.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BookClient {

	public void invokeGetBooks() {
		String url="https://openlibrary.org/api/books?bibkeys=ISBN:0451526538&format=json&jscmd=data";
		WebClient client = WebClient.create();
		String block = client.get().uri(url).retrieve().bodyToMono(String.class).block();
		System.out.println(block);
	}
}
