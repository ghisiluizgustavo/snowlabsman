package me.ghisiluizgustavo.infrastructure.rental.dto;

import jakarta.validation.constraints.NotEmpty;
import me.ghisiluizgustavo.usecase.rental.dto.IRentBooks;

import java.util.List;

public record RentBooksDTO(
        @NotEmpty
        String customerId,
        @NotEmpty
        List<String> booksIds
) implements IRentBooks { }
