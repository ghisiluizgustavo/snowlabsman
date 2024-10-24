package me.ghisiluizgustavo.infrastructure.book.dto;

import jakarta.validation.constraints.NotEmpty;
import me.ghisiluizgustavo.usecase.book.dto.IBookCreate;

public record CreateBookDTO (

        @NotEmpty
        String isbn,

        @NotEmpty
        String name,

        @NotEmpty
        String author
) implements IBookCreate { }
