package me.ghisiluizgustavo.book.dto;

import me.ghisiluizgustavo.book.model.Book;

public interface IBookUpdate {

    String isbn();
    String name();
    String author();
    Boolean available();
}
