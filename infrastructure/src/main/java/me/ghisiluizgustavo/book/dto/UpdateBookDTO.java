package me.ghisiluizgustavo.book.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateBookDTO(

        @NotEmpty
        String isbn,
        @NotEmpty
        String name,
        @NotEmpty
        String author,
        @NotNull
        Boolean available

) implements IBookUpdate { }
