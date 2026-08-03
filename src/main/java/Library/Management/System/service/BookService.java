package Library.Management.System.service;

import Library.Management.System.dto.BookRequest;
import Library.Management.System.dto.BookResponse;
import Library.Management.System.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

   List<BookResponse> getAllBooks();

    Optional<Book> getBookById(Long id);

    BookResponse createBook(BookRequest request);

    BookResponse updateBook(Long id, BookRequest request);

    void deleteBook(Long id);;

}