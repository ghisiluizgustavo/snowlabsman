package me.ghisiluizgustavo.domain.book.gateway;

import me.ghisiluizgustavo.domain.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookPersistenceGateway {

    Book save(Book book);
    Book findById(String id);
    Page<Book> findlAllBooks(Pageable pageable);

    void deleteBook(String id);

    Book updateBook(String id, Book book);

    void makeUnavailable(String id);
}
