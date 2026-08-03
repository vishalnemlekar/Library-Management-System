package Library.Management.System.controller;

import Library.Management.System.dto.BookRequest;
import Library.Management.System.dto.BookResponse;
import Library.Management.System.entity.Book;
import Library.Management.System.service.BookService;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
public List<BookResponse> getAllBooks() {
    return service.getAllBooks();
}

@GetMapping("/{id}")
public Optional<Book> getBookById(@PathVariable Long id) {
    return service.getBookById(id);
}

@PostMapping
public BookResponse createBook(@RequestBody BookRequest request) {
    return service.createBook(request);
}

@PutMapping("/{id}")
public BookResponse updateBook(@PathVariable Long id,
                       @RequestBody BookRequest request) {

    return service.updateBook(id, request);
}

@DeleteMapping("/{id}")
public void deleteBook(@PathVariable Long id) {

    service.deleteBook(id);
}
}