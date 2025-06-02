package in.ashokit.binding;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJsonConverter  {

	public static void main(String[] args) throws Exception {
		
		Author author = new Author("Murakami","kj@hotmail",354654654L);
		
		Book book = new Book(101,"Spring",40.00,author);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("book.json"), book);
		System.out.println("Conversion completed");
		
	}
}
