package me.ghisiluizgustavo.usecase.book;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.domain.book.gateway.BookPersistenceGateway;
import me.ghisiluizgustavo.domain.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAllBooksUseCase {

    private final BookPersistenceGateway bookPersistenceGateway;

    public Page<Book> execute(Pageable pageable){
        return bookPersistenceGateway.findlAllBooks(pageable);
    }

}
