package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRESTController {

	@GetMapping("/book/{name}")
	public ResponseEntity<String> getBookPrice(@PathVariable("name") String name) {

		String respBody = "the book price is: " + name;
		return new ResponseEntity<String>(respBody, HttpStatus.OK);
	}

	@GetMapping("/book/{name}/{price}")
	public ResponseEntity<String> getBookDetails(@PathVariable("name") String bookName,
			@PathVariable("price") Integer price) {

		String resBody = "book name " + bookName + " \nbook price: " + price;
		return new ResponseEntity<String>(resBody, HttpStatus.OK);
	}

}
