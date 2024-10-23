package me.ghisiluizgustavo.book;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.ID;
import me.ghisiluizgustavo.book.dto.IBookCreate;
import me.ghisiluizgustavo.book.dto.IBookUpdate;
import me.ghisiluizgustavo.book.gateway.BookGateway;
import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.book.model.Isbn;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateBookUseCase {

    private final BookGateway bookGateway;

    public Book execute(String id, IBookUpdate bookUpdate){
        var book = new Book(
                new ID(id),
                new Isbn(bookUpdate.isbn()),
                bookUpdate.name(),
                bookUpdate.author(),
                bookUpdate.available()
        );

        return bookGateway.updateBook(id, book);
    }

}
