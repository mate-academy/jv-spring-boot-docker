package mate.academy.boot.hellobootdemo.service;

import java.util.List;
import java.util.Optional;

import mate.academy.boot.hellobootdemo.entity.Book;
import mate.academy.boot.hellobootdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
