package me.ghisiluizgustavo.book;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.book.gateway.BookGateway;
import me.ghisiluizgustavo.book.model.Book;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindBookByIdUseCase {

    private final BookGateway bookGateway;

    public Book execute(String id){
        return bookGateway.findById(id);
    }

}
