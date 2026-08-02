package Library.Management.System.controller;

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
public List<Book> getAllBooks() {
    return service.getAllBooks();
}

@GetMapping("/{id}")
public Optional<Book> getBookById(@PathVariable Long id) {
    return service.getBookById(id);
}

@PostMapping
public Book createBook(@RequestBody Book book) {
    return service.createBook(book);
}

@PutMapping("/{id}")
public Book updateBook(@PathVariable Long id,
                       @RequestBody Book book) {

    return service.updateBook(id, book);
}

@DeleteMapping("/{id}")
public void deleteBook(@PathVariable Long id) {

    service.deleteBook(id);
}
}