package me.ghisiluizgustavo.book;

import me.ghisiluizgustavo.book.dto.IBookCreate;
import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.book.gateway.BookNotificationGateway;
import me.ghisiluizgustavo.book.gateway.BookPersistenceGateway;
import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.book.model.Isbn;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBookUseCase {

    private final BookPersistenceGateway bookPersistenceGateway;
    private final BookNotificationGateway bookNotificationGateway;

    public Book execute(IBookCreate book){
        var bookDomain = new Book(null, new Isbn(book.isbn()), book.name(), book.author(), true);

        Book savedBook = bookPersistenceGateway.save(bookDomain);

        bookNotificationGateway.notifyCreatedBook(savedBook);

        return savedBook;
    }

}
