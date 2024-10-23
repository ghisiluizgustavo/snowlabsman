package me.ghisiluizgustavo.book.gateway;

import me.ghisiluizgustavo.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookPersistenceGateway {

    Book save(Book book);
    Book findById(String id);
    Page<Book> findlAllBooks(Pageable pageable);

    void deleteBook(String id);

    Book updateBook(String id, Book book);
}
