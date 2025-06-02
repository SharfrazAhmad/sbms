package in.nit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.nit.entity.Book;
import in.nit.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository repository;

	public BookServiceImpl(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public String upsertBook(Book book) {
		Integer bookId = book.getBookId();
		repository.save(book);
		if (bookId == null) {
			return "record inserted";
		}
		return "record updated";
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> allBooks = repository.findAll();
		return allBooks;
	}

	@Override
	public String deleteBook(Integer book_id) {
		repository.deleteById(book_id);
		return "Book deleted";
	}

}
