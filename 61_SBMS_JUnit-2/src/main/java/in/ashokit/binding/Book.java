package in.ashokit.binding;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private Integer bookId;
	private String  bookName;
	
	
}
