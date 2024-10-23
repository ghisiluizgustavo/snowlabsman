package me.ghisiluizgustavo.rental.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record RentBooksDTO(
        @NotEmpty
        String customerId,
        @NotEmpty
        List<String> booksIds
) implements IRentBooks { }
