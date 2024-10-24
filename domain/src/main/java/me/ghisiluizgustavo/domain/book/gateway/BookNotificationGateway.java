package me.ghisiluizgustavo.domain.book.gateway;

import me.ghisiluizgustavo.domain.book.model.Book;

public interface BookNotificationGateway {

    void notifyCreatedBook(Book book);

    void notifyUpdatedBook(Book book);

    void notifyDeletedBook(String id);
}
