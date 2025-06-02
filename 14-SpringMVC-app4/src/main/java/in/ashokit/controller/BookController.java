package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.binding.Book;

@Controller
public class BookController {

	@GetMapping("/book")
	public String getBookData(Model model) {
		
		Book bookObj = new Book(101, "Spring", 450.22);
		model.addAttribute("book", bookObj);
		
		return "book";
	}
	
}
