package me.ghisiluizgustavo.domain.book.model;

import me.ghisiluizgustavo.domain.ID;
import org.apache.logging.log4j.util.Strings;

public record Book(ID id, Isbn isbn, String name, String author, Boolean available) {
    public Book {
        if (isbn == null) {
            throw new IllegalArgumentException("The book ISBN is a mandatory field");
        }
        if (Strings.isBlank(name)) {
            throw new IllegalArgumentException("The book name is a mandatory field");
        }
        if (Strings.isBlank(author)) {
            throw new IllegalArgumentException("The book author is a mandatory field");
        }
    }

    public boolean isAvailable(){
        return this.available;
    }
}