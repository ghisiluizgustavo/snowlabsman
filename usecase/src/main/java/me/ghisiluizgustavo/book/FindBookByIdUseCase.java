package me.ghisiluizgustavo.book;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.book.gateway.BookPersistenceGateway;
import me.ghisiluizgustavo.book.model.Book;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindBookByIdUseCase {

    private final BookPersistenceGateway bookPersistenceGateway;

    public Book execute(String id){
        return bookPersistenceGateway.findById(id);
    }

}
