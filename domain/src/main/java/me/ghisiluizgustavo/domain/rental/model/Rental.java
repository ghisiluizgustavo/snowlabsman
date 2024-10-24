package me.ghisiluizgustavo.domain.rental.model;

import me.ghisiluizgustavo.domain.ID;
import me.ghisiluizgustavo.domain.book.model.Book;
import me.ghisiluizgustavo.domain.customer.model.Customer;
import me.ghisiluizgustavo.domain.rental.exception.BookNotAvailableException;

import java.time.LocalDateTime;

public record Rental(ID id, Customer customer, Book book, LocalDateTime rentalDate, LocalDateTime devolutionDate) {
    public Rental {
        if (customer == null) {
            throw new IllegalArgumentException("To rent books is needed a customer");
        }
        if (book == null) {
            throw new IllegalArgumentException("To rent books is needed at least one book");
        }

        if (!book.isAvailable()) {
            throw new BookNotAvailableException("The book " + book.name() + " is not available to be rent");
        }
    }
}
