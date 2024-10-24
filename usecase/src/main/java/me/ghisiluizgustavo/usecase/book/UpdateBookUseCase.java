package me.ghisiluizgustavo.usecase.book;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.domain.ID;
import me.ghisiluizgustavo.usecase.book.dto.IBookUpdate;
import me.ghisiluizgustavo.domain.book.gateway.BookNotificationGateway;
import me.ghisiluizgustavo.domain.book.gateway.BookPersistenceGateway;
import me.ghisiluizgustavo.domain.book.model.Book;
import me.ghisiluizgustavo.domain.book.model.Isbn;
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
