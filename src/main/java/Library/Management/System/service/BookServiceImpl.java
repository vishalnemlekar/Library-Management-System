package Library.Management.System.service;

import Library.Management.System.dto.BookRequest;
import Library.Management.System.dto.BookResponse;
import Library.Management.System.entity.Book;
import Library.Management.System.repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookResponse mapToResponse(Book book) {

        BookResponse dto = new BookResponse();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setTotalCopies(book.getTotalCopies());
        dto.setAvailableCopies(book.getAvailableCopies());

        return dto;
    }

    private Book mapToEntity(BookRequest dto) {

        Book book = new Book();

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setTotalCopies(dto.getTotalCopies());
        book.setAvailableCopies(dto.getAvailableCopies());

        return book;
    }

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return repository.findAll()
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    @Override
    public BookResponse createBook(BookRequest request) {

        Book book = mapToEntity(request);

        Book savedBook = repository.save(book);

        return mapToResponse(savedBook);
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest request) {
         Book book = mapToEntity(request);

    book.setId(id);

    Book updatedBook = repository.save(book);

    return mapToResponse(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}