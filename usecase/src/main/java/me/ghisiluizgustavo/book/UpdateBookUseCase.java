package me.ghisiluizgustavo.book;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.ID;
import me.ghisiluizgustavo.book.dto.IBookUpdate;
import me.ghisiluizgustavo.book.gateway.BookNotificationGateway;
import me.ghisiluizgustavo.book.gateway.BookPersistenceGateway;
import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.book.model.Isbn;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateBookUseCase {

    private final BookPersistenceGateway bookPersistenceGateway;
    private final BookNotificationGateway bookNotificationGateway;

    public Book execute(String id, IBookUpdate bookUpdate){
        var book = new Book(
                new ID(id),
                new Isbn(bookUpdate.isbn()),
                bookUpdate.name(),
                bookUpdate.author(),
                bookUpdate.available()
        );

        Book savedBook = bookPersistenceGateway.updateBook(id, book);

        bookNotificationGateway.notifyUpdatedBook(savedBook);

        return savedBook;
    }

}
