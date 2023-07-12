package br.com.joaojesus.bookservice.repository;

import br.com.joaojesus.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

  Optional<Book> findById(Long id);
}
