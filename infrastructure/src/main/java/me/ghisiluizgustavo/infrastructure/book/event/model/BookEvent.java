package me.ghisiluizgustavo.infrastructure.book.event.model;

import lombok.Getter;
import me.ghisiluizgustavo.domain.book.model.Book;
import org.springframework.context.ApplicationEvent;

@Getter
public class BookEvent extends ApplicationEvent {

    private final Book book;
    private final StatusEventBook status;


    public BookEvent(Object source, Book book, StatusEventBook status) {
        super(source);
        this.book = book;
        this.status = status;
    }

}
