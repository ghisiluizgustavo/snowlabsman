package me.ghisiluizgustavo.book.gateway;

import me.ghisiluizgustavo.book.model.Book;

public interface BookNotificationGateway {

    void notifyCreatedBook(Book book);

    void notifyUpdatedBook(Book book);

    void notifyDeletedBook(String id);
}
