package in.ashokit.binding;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private Integer id;
	private String name;
	private double price;
	
	private Author author;
	
}
