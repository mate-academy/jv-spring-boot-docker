package mate.academy.boot.hellobootdemo.service;

import java.util.List;
import java.util.Optional;

import mate.academy.boot.hellobootdemo.entity.Book;
import org.springframework.data.domain.Pageable;

public interface BookService {
    List<Book> findAll(Pageable pageable);

    Optional<Book> findById(Long id);

    Book save(Book book);

    void delete(Long bookId);

    Book update(Book book, Long bookId);
}
