package in.nit.service;

import java.util.List;

import in.nit.entity.Book;

public interface BookService {

	public String upsertBook(Book book);

	public List<Book> getAllBooks();

	public String deleteBook(Integer book_id);
}
