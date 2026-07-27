package Library.Management.System.repository;
import Library.Management.System.entity.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositoy extends JpaRepository<Book, Long>{
Optional<Book> findByIsbn(String isbn);

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    boolean existsByIsbn(String isbn);
}
