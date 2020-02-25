package mate.academy.boot.hellobootdemo.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import io.swagger.annotations.ApiOperation;
import mate.academy.boot.hellobootdemo.entity.Book;
import mate.academy.boot.hellobootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    @ApiOperation(value = "Finds All Books",
            notes = "List all books that we have in our library",
            response = Book.class,
            responseContainer = "List")
    public List<Book> allBooks(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "limit", defaultValue = "20") Integer limit,
                               @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
                               @RequestParam(value = "sortOrder", defaultValue = "asc") String sortOrder) {
        Sort.Direction orderingDirection = Sort.Direction.fromString(sortOrder);
        Sort sortByRequest = Sort.by(orderingDirection, sortBy);
        Pageable pageRequest = PageRequest.of(page, limit, sortByRequest);
        return bookService.findAll(pageRequest);
    }

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable("bookId") Long id) {
        return bookService.findById(id).orElseThrow(() -> new EntityNotFoundException("Custom message"));
    }

    @PostMapping
    public void add(@RequestBody Book book) {
        bookService.save(book);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Long id) {
        bookService.delete(id);
    }

    @PutMapping("/{bookId}")
    public Book update(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
        return bookService.update(book, bookId);
    }
}
