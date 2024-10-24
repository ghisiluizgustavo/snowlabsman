package me.ghisiluizgustavo.infrastructure.book.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import me.ghisiluizgustavo.usecase.book.dto.IBookUpdate;

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
