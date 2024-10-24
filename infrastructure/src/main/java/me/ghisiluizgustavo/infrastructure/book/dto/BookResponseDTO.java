package me.ghisiluizgustavo.infrastructure.book.dto;

import me.ghisiluizgustavo.usecase.book.dto.IBookCreate;
import me.ghisiluizgustavo.usecase.book.dto.IBookUpdate;
import me.ghisiluizgustavo.domain.book.model.Book;

public record BookResponseDTO(
        String id,
        String isbn,
        String name,
        String author,
        Boolean available
) implements IBookCreate, IBookUpdate {
    public BookResponseDTO(Book book) {
        this(
                book.id().value(),
                book.isbn().value(),
                book.name(),
                book.author(),
                book.available()
        );
    }
}
