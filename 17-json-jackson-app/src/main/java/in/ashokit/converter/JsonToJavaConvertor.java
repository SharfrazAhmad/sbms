package in.ashokit.converter;


import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.binding.Book;

public class JsonToJavaConvertor {

	public static void main(String[] args) throws Exception {
		File file = new File("book.json");
		ObjectMapper mapper = new ObjectMapper();
		Book book = mapper.readValue(file, Book.class);
		System.out.println(book);
		
		
	}
	
	
}

