package me.ghisiluizgustavo.book;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.domain.book.gateway.BookNotificationGateway;
import me.ghisiluizgustavo.domain.book.gateway.BookPersistenceGateway;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteBookUseCase {

    private final BookPersistenceGateway bookPersistenceGateway;
    private final BookNotificationGateway bookNotificationGateway;

    public void execute(String id){
        bookPersistenceGateway.deleteBook(id);
        bookNotificationGateway.notifyDeletedBook(id);
    }

}
