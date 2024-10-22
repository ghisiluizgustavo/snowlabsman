package me.ghisiluizgustavo.book.gateway;

import me.ghisiluizgustavo.book.db.entity.BookEntity;
import me.ghisiluizgustavo.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.book.exception.BookNotFoundException;
import me.ghisiluizgustavo.book.model.Book;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDatabaseGateway implements BookGateway {

    private final BookRepository bookRepository;

    @Override
    public Book create(Book book){
        return bookRepository.save(new BookEntity(book)).toBook();
    }

    @Override
    public Book findById(String id) {
        return bookRepository
                .findById(id)
                .map(BookEntity::toBook)
                .orElseThrow(() -> new BookNotFoundException("Book with id: " + id + " was not found"));
    }


}
