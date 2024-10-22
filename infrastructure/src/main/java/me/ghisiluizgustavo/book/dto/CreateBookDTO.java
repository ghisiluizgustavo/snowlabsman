package me.ghisiluizgustavo.book.dto;

import jakarta.validation.constraints.NotEmpty;

public record CreateBookDTO (

        @NotEmpty
        String isbn,

        @NotEmpty
        String name,

        @NotEmpty
        String author
) implements IBookCreate { }
