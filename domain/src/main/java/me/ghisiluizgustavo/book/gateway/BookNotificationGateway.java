package me.ghisiluizgustavo.book.gateway;

import me.ghisiluizgustavo.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookNotificationGateway {

    void notifyCreatedBook(Book book);

    void notifyUpdatedBook(Book book);

    void notifyDeletedBook(String id);
}
