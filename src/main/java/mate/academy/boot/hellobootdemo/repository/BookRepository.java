package mate.academy.boot.hellobootdemo.repository;

import mate.academy.boot.hellobootdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

