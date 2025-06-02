package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Book;

@RestController
public class BookRestController {
	
	@PostMapping("/books")
	public ResponseEntity<String> addBook(@RequestBody Book book){

		
//		logic to store data in database
		System.out.println(book);
		String msg="Successfully stored in database";
		
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
}
