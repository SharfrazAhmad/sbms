package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Book;
import in.ashokit.services.BookServices;

@RestController
public class BookRestController {

	@Autowired
	private BookServices bookServices;

	
	@PostMapping(value = "/addBook", consumes = {"application/json"})
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		String msg = null;
		boolean saveBook = bookServices.saveBook(book);
		if (saveBook) {
			msg = "Book saved";
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		} else {
			msg = "Failed to save";
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

	}

}
