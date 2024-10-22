package me.ghisiluizgustavo.book.gateway;

import me.ghisiluizgustavo.book.model.Book;

public interface BookGateway {

    Book create(Book book);
    Book findById(String id);
}
