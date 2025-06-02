package in.nit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.entity.Book;

public interface BookRepository extends JpaRepository<Book, Serializable>{

}
