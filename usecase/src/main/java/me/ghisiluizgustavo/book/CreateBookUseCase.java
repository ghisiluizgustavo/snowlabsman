package me.ghisiluizgustavo.book;

import me.ghisiluizgustavo.book.dto.IBookCreate;
import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.book.gateway.BookGateway;
import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.book.model.Isbn;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBookUseCase {

    private final BookGateway bookGateway;

    public Book execute(IBookCreate book){
        var bookDomain = new Book(null, new Isbn(book.isbn()), book.name(), book.author(), true);
        return bookGateway.create(bookDomain);
    }

}
