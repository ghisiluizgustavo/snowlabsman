package me.ghisiluizgustavo.book;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.book.gateway.BookGateway;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteBookUseCase {

    private final BookGateway bookGateway;

    public void execute(String id){
        bookGateway.deleteBook(id);
    }

}
