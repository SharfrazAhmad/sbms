package in.ashokit.services;

import org.springframework.stereotype.Service;

import in.ashokit.binding.Book;

@Service
public class BookServices {

    public boolean saveBook(Book book) {
        // Here we simply return true assuming the book was "saved" successfully.
        // You could replace this with actual logic like saving to a database or list.
        if (book != null && book.getBookId() != null && book.getBookName() != null) {
            // Simulate save logic
            System.out.println("Book saved: " + book);
            return true;
        } else {
            return false;
        }
    }
}
